import { EventOrgService } from 'src/app/services/organizerService/eventServiceOrg/event-org.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-add-event',
  templateUrl: './add-event.component.html',
  styleUrls: ['./add-event.component.css']
})
export class AddEventComponent implements OnInit {

  event={
    eventId:null,
    eventName:null,
    eventCost:null,
    venueId:null,
  }

  
  constructor(private _route:ActivatedRoute,private eventService:EventOrgService,
    private route:Router) { }

  ngOnInit(): void {
    this.event.venueId = this._route.snapshot.params.venueId;
  }

  addEvent(){
    this.eventService.addNewEvent(this.event).subscribe(
      (data)=>{
        this.event.eventName=null;this.event.eventCost=null;
        this.route.navigate(["organizer/venueDetails/"+this.event.venueId+"/showEvents/"+this.event.venueId]);
      },
      (error)=>{
        Swal.fire("Error","Problem in adding Event","error");
      }
    );
  }

}
