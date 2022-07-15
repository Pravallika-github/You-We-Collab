import { VenueUserService } from './../../../../services/userService/venuesUser/venue-user.service';
import { ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { EquipmentOrgService } from 'src/app/services/organizerService/eventServiceOrg/equipment-org.service';

@Component({
  selector: 'app-equipments-user',
  templateUrl: './equipments-user.component.html',
  styleUrls: ['./equipments-user.component.css']
})
export class EquipmentsUserComponent implements OnInit {

  venueId=0;
  equipments:any;

  constructor(private _route:ActivatedRoute, private _service:EquipmentOrgService) { }

  ngOnInit(): void {

    this.venueId = this._route.snapshot.params.venueId;
  
     this._service.getEquipmentsByVenueId(this.venueId).subscribe(

       (equipments)=>{
         this.equipments = equipments;
       },
       (error)=>{
         alert("Something went Wrong");
      }
      );

  }

}
