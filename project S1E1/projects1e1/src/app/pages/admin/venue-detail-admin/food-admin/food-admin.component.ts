import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FoodOrgService } from 'src/app/services/organizerService/eventServiceOrg/food-org.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-food-admin',
  templateUrl: './food-admin.component.html',
  styleUrls: ['./food-admin.component.css']
})
export class FoodAdminComponent implements OnInit {

  venueId=0;
  foodItems:any;

  constructor(private _route:ActivatedRoute, private _service:FoodOrgService) { }

  ngOnInit(): void {

    this.venueId = this._route.snapshot.params.venueId;
  
    // Get List of Venues
     this._service.getFoodItemsByVenueId(this.venueId).subscribe(
       (foodItems)=>{ this.foodItems = foodItems; },
       (error)=>{
         Swal.fire("Something went Wrong"); }
      );

  }

}
