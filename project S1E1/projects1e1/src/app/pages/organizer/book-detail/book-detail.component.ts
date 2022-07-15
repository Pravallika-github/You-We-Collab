import { ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { AdminBookingServiceService } from 'src/app/services/adminService/adminBookingService/admin-booking-service.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-book-detail',
  templateUrl: './book-detail.component.html',
  styleUrls: ['./book-detail.component.css']
})
export class BookDetailComponent implements OnInit {
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
