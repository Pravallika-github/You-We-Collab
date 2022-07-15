import { VenueUserService } from './../../../services/userService/venuesUser/venue-user.service';
import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-view-venues',
  templateUrl: './view-venues.component.html',
  styleUrls: ['./view-venues.component.css']
})
export class ViewVenuesComponent implements OnInit {

  venues:any;
  constructor(private venueUserService:VenueUserService) { }

  ngOnInit(): void {
    this.venueUserService.getAllVenues().subscribe(
      (venues)=>{
        this.venues = venues;
      },
      (error)=>{
        Swal.fire("Error","Problem in loading Venues","error");
      }
      )
  }

}
