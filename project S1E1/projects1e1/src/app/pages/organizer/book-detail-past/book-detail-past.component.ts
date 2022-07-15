import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AdminBookingServiceService } from 'src/app/services/adminService/adminBookingService/admin-booking-service.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-book-detail-past',
  templateUrl: './book-detail-past.component.html',
  styleUrls: ['./book-detail-past.component.css']
})
export class BookDetailPastComponent implements OnInit {
  bookingId:any;
  booking:any;
  constructor(private _route:ActivatedRoute,private bookingService:AdminBookingServiceService) { }

  ngOnInit(): void {

    this.bookingId = this._route.snapshot.params.bookingId;

    // Get Booking Details
    this.bookingService.bookingDetail(this.bookingId).subscribe(
      (data)=>{
        this.booking= data;
      },(error)=>{
        Swal.fire("Error","There is error while loading Booking Detail","error");
      }
    )
  }

}
