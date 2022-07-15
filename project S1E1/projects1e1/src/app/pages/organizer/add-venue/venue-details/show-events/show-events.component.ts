import { EventOrgService } from './../../../../../services/organizerService/eventServiceOrg/event-org.service';
import { ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-show-events',
  templateUrl: './show-events.component.html',
  styleUrls: ['./show-events.component.css']
})
export class ShowEventsComponent implements OnInit {

  events:any;
  venueId=0;
  constructor(private _route : ActivatedRoute,private eventService:EventOrgService) { }

  ngOnInit(): void {
    this.venueId = this._route.snapshot.params.venueId;
    //alert(this.venueId);
     this.eventService.getEventsByVenueId(this.venueId).subscribe(

       (events)=>{
         this.events = events;
         console.log(events);
       },
       (error)=>{
         alert("Something went Wrong");
      }
      );
  }


  public deleteEvent(eventId:any){
   
          
          this.eventService.deleteEvent(eventId).subscribe(
            (data)=>{
              this.events = this.events.filter((event:any)=>event.eventId!=eventId);
              
            },(error)=>{
              Swal.fire("Error","Error in deleting Food Item","error");
            }
          )
  }

}
