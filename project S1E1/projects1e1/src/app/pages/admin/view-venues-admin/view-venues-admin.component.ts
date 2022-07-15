import { Component, OnInit } from '@angular/core';
import { VenueUserService } from 'src/app/services/userService/venuesUser/venue-user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-view-venues-admin',
  templateUrl: './view-venues-admin.component.html',
  styleUrls: ['./view-venues-admin.component.css']
})
export class ViewVenuesAdminComponent implements OnInit {

  venues:any;
  constructor(private venueUserService:VenueUserService) { }

  ngOnInit(): void {
    // Get All Venues
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
