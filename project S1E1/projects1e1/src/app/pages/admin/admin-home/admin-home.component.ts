import { AdminBookingServiceService } from 'src/app/services/adminService/adminBookingService/admin-booking-service.service';
import { MemberService } from 'src/app/services/member.service';
import { Component, OnInit } from '@angular/core';
import { VenueUserService } from 'src/app/services/userService/venuesUser/venue-user.service';

@Component({
  selector: 'app-admin-home',
  templateUrl: './admin-home.component.html',
  styleUrls: ['./admin-home.component.css']
})
export class AdminHomeComponent implements OnInit {

  users:any;
  useNum:any;
  organizers:any;
  orgNum:any;
  venues:any;
  venueNum:any;
  bookings:any;
  numBooking:any;
  constructor(private memberService : MemberService,
    private venueUserService:VenueUserService,
    private bookingService:AdminBookingServiceService) { }

  ngOnInit(): void {
    // Get All Users Number
    this.memberService.getAllUsers().subscribe(
      (data)=>{ this.users = data; this.useNum=this.users.length;},
      (error)=>{ console.log(error);}
    );

    // Get All Organizers Number
    this.memberService.getAllOrganizers().subscribe(
      (data)=>{ this.organizers = data; this.orgNum=this.organizers.length;},
      (error)=>{ console.log(error);}
    );

    // Get All Venues Number
    this.venueUserService.getAllVenues().subscribe(
      (venues)=>{ this.venues = venues; this.venueNum=this.venues.length;},
      (error)=>{ console.log(error);}
      );

      // Get All Venues Number
    this.bookingService.getAllBookings().subscribe(
      (data)=>{ this.bookings = data; this.numBooking = this.bookings.length; },
      (error)=>{ console.log(error);}
      );

  }
}
