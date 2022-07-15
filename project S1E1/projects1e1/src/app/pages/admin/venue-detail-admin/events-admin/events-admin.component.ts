import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { EventOrgService } from 'src/app/services/organizerService/eventServiceOrg/event-org.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-events-admin',
  templateUrl: './events-admin.component.html',
  styleUrls: ['./events-admin.component.css']
})
export class EventsAdminComponent implements OnInit {

  venueId=0;
  events:any;

  constructor(private _route:ActivatedRoute, private _service:EventOrgService) { }

  ngOnInit(): void {

    this.venueId = this._route.snapshot.params.venueId;
  
    // Get List of Events
     this._service.getEventsByVenueId(this.venueId).subscribe(
       (events)=>{ this.events = events; },
       (error)=>{ Swal.fire("Something went Wrong"); }
      );
  }

}
