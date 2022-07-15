import { FoodOrgService } from 'src/app/services/organizerService/eventServiceOrg/food-org.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { EventOrgService } from 'src/app/services/organizerService/eventServiceOrg/event-org.service';

@Component({
  selector: 'app-food-user',
  templateUrl: './food-user.component.html',
  styleUrls: ['./food-user.component.css']
})
export class FoodUserComponent implements OnInit {
  venueId=0;
  foodItems:any;

  constructor(private _route:ActivatedRoute, private _service:FoodOrgService) { }

  ngOnInit(): void {

    this.venueId = this._route.snapshot.params.venueId;
  
     this._service.getFoodItemsByVenueId(this.venueId).subscribe(

       (foodItems)=>{
         this.foodItems = foodItems;
       },
       (error)=>{
         alert("Something went Wrong");
      }
      );

  }

}
