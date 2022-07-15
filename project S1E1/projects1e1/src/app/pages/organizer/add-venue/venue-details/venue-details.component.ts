import  Swal  from 'sweetalert2';
import { VenueOrgService } from './../../../../services/organizerService/venueServiceOrg/venue-org.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-venue-details',
  templateUrl: './venue-details.component.html',
  styleUrls: ['./venue-details.component.css']
})
export class VenueDetailsComponent implements OnInit {

  venueId=0;
  venue:any;
  constructor(private _route:ActivatedRoute,private venueService:VenueOrgService,
    private route:Router) { }

  ngOnInit(): void {
    this.venueId = this._route.snapshot.params.venueId;
    //alert(this.venueId);

    //get Venue Detail from Server
    this.venueService.getVenue(this.venueId).subscribe(
      (data)=>{
        this.venue=data;
        console.log(data);
      },
      (error)=>{
        console.log(error);
      }
    )

  }

  //Update Venue Details
  public updateVenue(){


    Swal.fire({icon:'info',
    title:'Are you sure ?',
    confirmButtonText:'Update',
    showCancelButton:true}).then(
      (result)=>{
        if (result.isConfirmed){



          this.venueService.updateVenue(this.venue).subscribe(
            (data)=>{
              console.log(data);
              this.route.navigate(["organizer/manageVenue"]);
            },
            (error)=>{
              Swal.fire("Error","Error in updating Venue");
            }
          )
        }
      }
    )
  }














  }
