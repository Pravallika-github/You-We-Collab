import { HistoryService } from './../../../services/userService/history.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { AdminBookingServiceService } from 'src/app/services/adminService/adminBookingService/admin-booking-service.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {

  cardName:any;
  month:any;
  year:any;
  cvv:any;
  cardNumber:any;


  bookingId:any;
  booking:any;
  constructor(private _route:ActivatedRoute,private bookingService:AdminBookingServiceService,
    private historyService:HistoryService, private router:Router) { }

  ngOnInit(): void {
    this.bookingId = this._route.snapshot.params.bookingId;

    this.bookingService.bookingDetail(this.bookingId).subscribe(
      (data)=>{
        this.booking= data;

      },(error)=>{
        Swal.fire("Error","There is error while loading Booking Detail","error");

      }
    )
  }

  check:any;
  public doPayment(){

    Swal.fire({icon:'info',
    title:'Pay For Booking',
    confirmButtonText:'Yes',
    showCancelButton:true}).then(
      (result)=>{
        if (result.isConfirmed){
          
          this.historyService.doPayment(this.bookingId).subscribe(
            (data)=>{
              this.check=data;
              if(this.check=1){
                Swal.fire({icon:'info',
                title:' Payment Processed',
                confirmButtonText:'OK',
                showCancelButton:true}).then(
                  (result)=>{
                    if (result.isConfirmed){
                      this.router.navigate(['/user/bookingHistory']);
                    }
                  }
                ); 
              }else if(this.check=1){
                Swal.fire("Sorry","You just missed your slot as someone else booked it with payment before you","error");
              }
            },(error)=>{
              Swal.fire("Sorry","Failed to process your payment","error");
            }
          )
        }})

        

  }

}
