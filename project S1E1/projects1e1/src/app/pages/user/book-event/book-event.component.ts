import { Router } from '@angular/router';
import { LoginService } from './../../../services/login.service';
import { FoodOrgService } from 'src/app/services/organizerService/eventServiceOrg/food-org.service';
import { VenueUserService } from './../../../services/userService/venuesUser/venue-user.service';
import { Component, OnInit } from '@angular/core';
import { EventOrgService } from 'src/app/services/organizerService/eventServiceOrg/event-org.service';
import { EquipmentOrgService } from 'src/app/services/organizerService/eventServiceOrg/equipment-org.service';
import Swal from 'sweetalert2';
import { analyzeAndValidateNgModules } from '@angular/compiler';

@Component({
  selector: 'app-book-event',
  templateUrl: './book-event.component.html',
  styleUrls: ['./book-event.component.css']
})
export class BookEventComponent implements OnInit {

  eventCost=0;
  totalCost=0;
  memberId:any;


  booking:any={
    bookingId:0,
    venueId:"Select Venue",
    eventName:'Select Event',
    date:null,
    guestCount:0,
    eventCost:this.eventCost,
    totalCost:this.totalCost,
    paymentStatus:'Pending',
    memberId:this.login.getMemberId(),
    selectedFoodItems:[],
    selectedEquipments:[],
  }
  even:any;



  places:any;
  venues:any;
  events:any;
  foodItems:any;
  equipments:any;
 
  equipmentCost=0;
  foodCost=0;
  
  
  helpCost=0;
  constructor(private venueUserService : VenueUserService,
              private eventService : EventOrgService,
              private foodService : FoodOrgService,
              private equipmentService : EquipmentOrgService,
              private login : LoginService,
              private router:Router) { }


              
  ngOnInit(): void {

    this.getDate();

    this.places= this.venueUserService.getAllPlaces().subscribe(
      (places)=>{
        console.log(places);
        this.places = places;
      },
      (error)=>{
        console.log(error);
      }
    )
    this.memberId = localStorage.getItem('memberId');
  }


  minDate:any;
  getDate(){
    var date = new Date();
    var toDate:any = date.getDate();
    var month:any = date.getMonth()+1;
    if(toDate<10){toDate ='0'+ toDate};
    if(month<10){month ='0'+ month};
    var year = date.getFullYear();
    this.minDate = year + "-" + month + "-" + toDate;

  }


  //get Venue for selected place
  public onSelectPlace(place:any){

    this.booking.venueId="Select Venue";
    this.booking.eventName='Select Event';
    this.booking.date=null;
    this.booking.guestCount=0,
    this.foodItems=null,
    this.equipments=null,
    this.totalCost=0,
    this.foodCost=0,
    this.equipmentCost=0,
    this.eventCost=0,

     this.venueUserService.getVenueOfPlace(place.target.value).subscribe(
      (venues)=>{
        this.venues=venues;
      },(error)=>{
        console.log(error);
      }
    )
  }


  //get Components for selected Veneu
  venueHasError=true;
  public onSelectVenue(venue:any){

    
      if (venue.target.value==="Select Venue"){
        this.venueHasError=true;
      }
      else{
        this.venueHasError=false;
      }


    this.booking.eventName='Select Event';
    this.booking.date=null;
    this.booking.guestCount=0,
    this.foodItems=null,
    this.equipments=null,
    this.totalCost=0,
    this.foodCost=0,
    this.equipmentCost=0,
    this.eventCost=0,

    /// Events
    this.eventService.getEventsByVenueId(venue.target.value).subscribe(

      (events)=>{
        this.events = events;
      },
      (error)=>{
        alert("error in loading events");
     }
     );


     /// Foods
    this.foodService.getFoodItemsByVenueId(venue.target.value).subscribe(

      (foodItems)=>{
        this.foodItems = foodItems;
      },
      (error)=>{
        alert("error in loading Food Items");
     }
     );


     /// Equipments
    this.equipmentService.getEquipmentsByVenueId(venue.target.value).subscribe(

      (equipments)=>{
        this.equipments = equipments;
      },
      (error)=>{
        alert("error in loading Food Items");
     }
     );
  } 

eventName='';
eventHasError=true;
   ///////Event Selected Processes
   public onSelectedEvent(event:any){

    if (event.target.value==="Select Event"){
      this.eventHasError=true;
    }
    else{
      this.eventHasError=false;
    }


     this.eventName = event.target.value;
     this.venueUserService.getEventByEventName(this.eventName,parseInt(this.booking.venueId)).subscribe(
       (event)=>{
         this.even = event ;
         this.eventCost=this.even.eventCost;
         
       }
     );
  }




  ////Selected Food Items
  public onSelectfoodItems(event:any,foodItem:any){
    if(event.target.checked){
      this.booking.selectedFoodItems.push(foodItem.foodItemId);
      this.foodCost=this.foodCost+(foodItem.foodItemCost);
      this.totalCost=this.totalCost+foodItem.foodItemCost
      

    }else{
      this.booking.selectedFoodItems = this.booking.selectedFoodItems.filter((m: any)=>m!=foodItem.foodItemId);
      this.foodCost=this.foodCost-foodItem.foodItemCost;
      this.totalCost=this.totalCost-foodItem.foodItemCost
      
    }
  }

    ////////Selected Equipments
  public onSelectEquipments(event:any,equipment:any){
    if(event.target.checked){
      this.booking.selectedEquipments.push(equipment.equipmentId);
      console.log(this.booking.selectedEquipments);
      this.equipmentCost=this.equipmentCost+equipment.equipmentCost;
      this.totalCost=this.totalCost+equipment.equipmentCost;
    }else{
      this.booking.selectedEquipments = this.booking.selectedEquipments.filter((m: any)=>m!=equipment.equipmentId);
      this.equipmentCost=this.equipmentCost-equipment.equipmentCost;
      this.totalCost=this.totalCost-equipment.equipmentCost;
    }
  }

 

  check:any;
  //////book Event
  public bookEvent(){
    Swal.fire({icon:'info',
    title:'Are you sure  ?',
    confirmButtonText:'Yes, Book',
    showCancelButton:true}).then(
      (result)=>{
        if (result.isConfirmed){

          this.booking.selectedFoodItems=this.booking.selectedFoodItems.toString();
          this.booking.selectedEquipments=this.booking.selectedEquipments.toString();
          
          this.venueUserService.bookEvent(this.booking).subscribe(
            (data)=>{ this.check=data;
              if(this.check == 1){
                     this.router.navigate(['user/payMessage']); 
              }else if(this.check == 0){
                Swal.fire("Ohh No","It seems that this date is already taken for this venue"+
                 " Please try to choose another date or Venue ","error")
              }
              console.log("check is "+this.check)
              
            },(error)=>{
              Swal.fire("Sorry","There is an error while Booking this Event","error")
            }
          )
        }})
    
    


    
  }


}
