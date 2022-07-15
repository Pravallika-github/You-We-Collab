import { FoodOrgService } from 'src/app/services/organizerService/eventServiceOrg/food-org.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-add-food-item',
  templateUrl: './add-food-item.component.html',
  styleUrls: ['./add-food-item.component.css']
})
export class AddFoodItemComponent implements OnInit {

  foodItem={
    foodItemId:null,
    foodItemName:null,
    foodItemCost:null,
    venueId:null
  }
  constructor(private _route:ActivatedRoute,private foodItemService:FoodOrgService,
    private route :Router) { }

  ngOnInit(): void {
    this.foodItem.venueId = this._route.snapshot.params.venueId;
  }

  addFoodItem(){
    this.foodItemService.addNewFoodItem(this.foodItem).subscribe(
      (data)=>{
        this.foodItem.foodItemName=null;this.foodItem.foodItemCost=null;
        this.route.navigate(["organizer/venueDetails/"+this.foodItem.venueId+"/showFoodItems/"+this.foodItem.venueId]);
      },
      (error)=>{
        Swal.fire("Error","Problem in adding Food Item","error");
      }
    );
  }

}
