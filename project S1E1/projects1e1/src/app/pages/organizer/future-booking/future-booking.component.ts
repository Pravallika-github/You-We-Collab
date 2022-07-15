import { OrganizerService } from './../../../services/organizerService/organizer.service';
import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-future-booking',
  templateUrl: './future-booking.component.html',
  styleUrls: ['./future-booking.component.css']
})
export class FutureBookingComponent implements OnInit {
  bookings:any;

  constructor(private orgService : OrganizerService) { }


  ngOnInit(): void {

    // All Upcoming Bookings
    this.orgService.getFutureBookingsByOrgId().subscribe(
      (data)=>{
        this.bookings = data;
      },
      (error)=>{
        Swal.fire("Error","Error in Loading Booking Data","error");
      }
    )

  }

}
