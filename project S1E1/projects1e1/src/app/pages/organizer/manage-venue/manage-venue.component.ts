import { VenueOrgService } from './../../../services/organizerService/venueServiceOrg/venue-org.service';
import { SidebarOrgComponent } from './../../../components/sidebar-org/sidebar-org.component';
import { OrganizerService } from './../../../services/organizerService/organizer.service';
import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-manage-venue',
  templateUrl: './manage-venue.component.html',
  styleUrls: ['./manage-venue.component.css']
})

export class ManageVenueComponent implements OnInit {

  venues:any;
  constructor(private orgService: OrganizerService,private venueService:VenueOrgService) { }

  ngOnInit(): void {
   
    this.orgService.getVenueByOrganizerId().subscribe(
      (venues)=>{ this.venues = venues; },
      (error)=>{ Swal.fire("Problem in loading Venues"); }
      )
  }

  checkAct:any;
  // delete venue..
  deleteVenue(venueId:any){
    this.venueService.checkActiveBooking(venueId).subscribe(
      (data)=>{
        this.checkAct = data;
        if(this.checkAct == 1 ){
          Swal.fire("You can not Delete this venue when there is an Active Booking")
        }else if(this.checkAct == 0){

          Swal.fire({icon:'info',
          title:'All your data, related to this venue such as events, equipments will also get delet. Do you want to Proceed ??',
          confirmButtonText:'Yes, Delete',
          showCancelButton:true}).then(
            (result)=>{
              if (result.isConfirmed){
          
                this.venueService.deleteVenue(venueId).subscribe(
                  (data)=>{
                    this.venues = this.venues.filter((venue:any)=>venue.venueId!=venueId);
                    Swal.fire("Success","Venue Deleted","success");
                  },(error)=>{
                    Swal.fire("Error","Error in deleting Venue","error");
                  }
                )
              }})

        }

      },
      (error:any)=>{console.log(error)}
    )

    // Swal.fire({icon:'info',
    // title:'Are you sure ?',
    // confirmButtonText:'Delete',
    // showCancelButton:true}).then(
    //   (result)=>{
    //     if (result.isConfirmed){
          
    //       this.venueService.deleteVenue(venueId).subscribe(
    //         (data)=>{
    //           this.venues = this.venues.filter((venue:any)=>venue.venueId!=venueId);
    //           Swal.fire("Success","Venue Deleted","success");
    //         },(error)=>{
    //           Swal.fire("Error","Error in deleting Venue","error");
    //         }
    //       )
    //     }})
  }

}
