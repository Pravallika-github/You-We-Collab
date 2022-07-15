import { EventOrgService } from 'src/app/services/organizerService/eventServiceOrg/event-org.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-update-event',
  templateUrl: './update-event.component.html',
  styleUrls: ['./update-event.component.css']
})
export class UpdateEventComponent implements OnInit {

  event:any;
  eventId=0;
  constructor(private _route:ActivatedRoute,private eventService:EventOrgService,
    private route:Router) { }

  ngOnInit(): void {
    this.eventId = this._route.snapshot.params.eventId;
    //alert(this.eventId);

    //get Event Details from Server
    this.eventService.getEvent(this.eventId).subscribe(
      (data)=>{
        this.event=data;
        console.log(data);
      },
      (error)=>{
        console.log(error);
      }
    )
  }

   //update Event
   public updateEvent(){
    this.eventService.updateEvent(this.event).subscribe(
      (data)=>{
        console.log(data);
        this.route.navigate(["organizer/venueDetails/"+this.event.venueId+"/showEvents/"+this.event.venueId]);
      },
      (error)=>{
        Swal.fire("Error","Error in updating Event");
      }
    )
  }

}
