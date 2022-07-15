import { FoodOrgService } from 'src/app/services/organizerService/eventServiceOrg/food-org.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-update-food',
  templateUrl: './update-food.component.html',
  styleUrls: ['./update-food.component.css']
})
export class UpdateFoodComponent implements OnInit {

  foodItemId=0;
  foodItem:any;
  constructor(private _route:ActivatedRoute,private foodService:FoodOrgService,
    private route:Router) { }

  ngOnInit(): void {
    this.foodItemId = this._route.snapshot.params.foodItemId;


    //get Food Item Details from Server
    this.foodService.getFoodItem(this.foodItemId).subscribe(
      (data)=>{
        this.foodItem=data;
      },
      (error)=>{
        console.log(error);
      }
    )
  }

    //update Food Item
    public updateFoodItem(){
      this.foodService.updateFoodItem(this.foodItem).subscribe(
        (data)=>{
          this.route.navigate(["organizer/venueDetails/"+this.foodItem.venueId+"/showFoodItems/"+this.foodItem.venueId]);
        },
        (error)=>{
          Swal.fire("Error","Error in updating Food Item");
        }
      )
    }

}
