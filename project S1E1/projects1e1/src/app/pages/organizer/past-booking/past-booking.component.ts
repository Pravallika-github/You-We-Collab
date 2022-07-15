import { Component, OnInit } from '@angular/core';
import { OrganizerService } from 'src/app/services/organizerService/organizer.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-past-booking',
  templateUrl: './past-booking.component.html',
  styleUrls: ['./past-booking.component.css']
})
export class PastBookingComponent implements OnInit {

  bookings:any;
  constructor(private orgService : OrganizerService) { }

  // Past Booking
  ngOnInit(): void {
    this.orgService.getPastBookingsByOrgId().subscribe(
      (data)=>{
        this.bookings = data;
      },
      (error)=>{
        Swal.fire("Error","Error in Loading Booking Data","error");
      }
    )
  }

}
