import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AdminBookingServiceService } from 'src/app/services/adminService/adminBookingService/admin-booking-service.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-booking-detail-user',
  templateUrl: './booking-detail-user.component.html',
  styleUrls: ['./booking-detail-user.component.css']
})
export class BookingDetailUserComponent implements OnInit {

  bookingId:any;
  booking:any;
  showPayButton:any;
  todayDate:any;
  constructor(private _route: ActivatedRoute,private bookingService :AdminBookingServiceService) { }

  ngOnInit(): void {

    this.bookingId = this._route.snapshot.params.bookingId;


    this.bookingService.bookingDetail(this.bookingId).subscribe(
      (data)=>{
        this.booking= data;
        this.showPayButton=1
        
          var date = new Date();
          var toDate:any = date.getDate();
          var month:any = date.getMonth()+1;
          if(toDate<10){toDate ='0'+ toDate};
          if(month<10){month ='0'+ month};
          var year = date.getFullYear();
          this.todayDate = year + "-" + month + "-" + toDate;



        if(this.todayDate > this.booking.date){
          this.showPayButton=0;
        }
        console.log(this.todayDate);
        console.log(this.booking.date);

      },(error)=>{
        Swal.fire("Error","There is error while loading Booking Detail","error");
      }
    );

   
  }

}
