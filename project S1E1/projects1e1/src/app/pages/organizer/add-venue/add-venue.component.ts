import { Router } from '@angular/router';
import { LoginService } from './../../../services/login.service';
import { VenueOrgService } from './../../../services/organizerService/venueServiceOrg/venue-org.service';
import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-add-venue',
  templateUrl: './add-venue.component.html',
  styleUrls: ['./add-venue.component.css']
})
export class AddVenueComponent implements OnInit {

  public venue={
    venueId:null,
    venueName:null,
    venuePlace:null,
    venueContact:null,
    memberId:this.login.getMember().memberId
  }

  constructor(private venueService:VenueOrgService,private login:LoginService,private router:Router) { }

public addVenue(){
  this.venueService.addVenueToDB(this.venue).subscribe(
    (data)=>{
      this.venue.venueContact=null;this.venue.venueName=null;this.venue.venuePlace=null
      this.router.navigate(["/organizer/manageVenue"]);
    },
    (error)=>{
      Swal.fire("Error","Problem in adding Venue ","error");
    }
  );
}

  ngOnInit(): void {
  }

}
