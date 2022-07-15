import { AdminBookingServiceService } from './../../../services/adminService/adminBookingService/admin-booking-service.service';
import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-view-bookings-admin',
  templateUrl: './view-bookings-admin.component.html',
  styleUrls: ['./view-bookings-admin.component.css']
})
export class ViewBookingsAdminComponent implements OnInit {

  constructor(private bookingService : AdminBookingServiceService) { }

  bookings:any;
  ngOnInit(): void {

    // Get All Bookings
    this.bookingService.getAllBookings().subscribe(
      (data)=>{
        this.bookings = data;
      },
      (error)=>{
        Swal.fire("Error","Error in Loading Booking Data","error");
      }
    )
  }

}
