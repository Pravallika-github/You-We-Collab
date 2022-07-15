import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { EventOrgService } from 'src/app/services/organizerService/eventServiceOrg/event-org.service';

@Component({
  selector: 'app-events-user',
  templateUrl: './events-user.component.html',
  styleUrls: ['./events-user.component.css']
})
export class EventsUserComponent implements OnInit {
  venueId=0;
  events:any;

  constructor(private _route:ActivatedRoute, private _service:EventOrgService) { }

  ngOnInit(): void {

    this.venueId = this._route.snapshot.params.venueId;
  
     this._service.getEventsByVenueId(this.venueId).subscribe(

       (events)=>{
         this.events = events;
       },
       (error)=>{
         alert("Something went Wrong");
      }
      );

  }
}
