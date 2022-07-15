import { EquipmentOrgService } from './../../../../../services/organizerService/eventServiceOrg/equipment-org.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { EventOrgService } from 'src/app/services/organizerService/eventServiceOrg/event-org.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-show-equipment',
  templateUrl: './show-equipment.component.html',
  styleUrls: ['./show-equipment.component.css']
})
export class ShowEquipmentComponent implements OnInit {

  venueId=0;
  equipments:any;
  constructor(private _route : ActivatedRoute,private equipmentService:EquipmentOrgService) { }

  ngOnInit(): void {
    this.venueId = this._route.snapshot.params.venueId;
    //alert(this.venueId);
     this.equipmentService.getEquipmentsByVenueId(this.venueId).subscribe(

       (equipments)=>{
         this.equipments = equipments;
       },
       (error)=>{
         alert("Something went Wrong");
      }
      );
  }

  public deleteEquipment(equipmentId:any){
   
          
          this.equipmentService.deleteEquipment(equipmentId).subscribe(
            (data)=>{
              this.equipments = this.equipments.filter((equipment:any)=>equipment.equipmentId!=equipmentId);
              
            },(error)=>{
              Swal.fire("Error","Error in deleting Equipment","error");
            }
          )
        
  }

}
