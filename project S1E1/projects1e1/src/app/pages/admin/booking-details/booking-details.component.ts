import { AdminBookingServiceService } from './../../../services/adminService/adminBookingService/admin-booking-service.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-booking-details',
  templateUrl: './booking-details.component.html',
  styleUrls: ['./booking-details.component.css']
})
export class BookingDetailsComponent implements OnInit {

  bookingId:any;
  booking:any;
  constructor(private _route: ActivatedRoute,
              private bookingService :AdminBookingServiceService) { }

  ngOnInit(): void {
    this.bookingId = this._route.snapshot.params.bookingId;

    // Get Single Bookings Detail
    this.bookingService.bookingDetail(this.bookingId).subscribe(
      (data)=>{ this.booking= data;},
      (error)=>{
        Swal.fire("Error","There is error while loading Booking Detail","error");
      }
    );
    
  }

}
