import { ActivatedRoute } from '@angular/router';
import { HistoryService } from './../../../services/userService/history.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-availability',
  templateUrl: './availability.component.html',
  styleUrls: ['./availability.component.css']
})
export class AvailabilityComponent implements OnInit {

  venueId:any;
  dates:any;
  constructor(private historyService:HistoryService, private route : ActivatedRoute) { }

  ngOnInit(): void {

    this.venueId = this.route.snapshot.params.venueId;
    this.historyService.getDates(this.venueId).subscribe(
      (dates)=>{
        this.dates = dates;
      },
      (error)=>{
        console.log(error);
      }
    )
  }

}
