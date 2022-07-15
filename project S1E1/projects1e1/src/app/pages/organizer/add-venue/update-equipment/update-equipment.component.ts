import { EquipmentOrgService } from './../../../../services/organizerService/eventServiceOrg/equipment-org.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-update-equipment',
  templateUrl: './update-equipment.component.html',
  styleUrls: ['./update-equipment.component.css']
})
export class UpdateEquipmentComponent implements OnInit {

  equipment:any;
  equipmentId=0;
  constructor(private _route:ActivatedRoute,private equipmentService:EquipmentOrgService,
    private route:Router) { }

  ngOnInit(): void {
    this.equipmentId = this._route.snapshot.params.equipmentId;
    //alert(this.eventId);

    //get Event Details from Server
    this.equipmentService.getEquipment(this.equipmentId).subscribe(
      (data)=>{
        this.equipment=data;
        console.log(data);
      },
      (error)=>{
        console.log(error);
      }
    )
  }

    //update Equipment
    public updateEquipment(){
      this.equipmentService.updateEquipment(this.equipment).subscribe(
        (data)=>{
          console.log(data);
          this.route.navigate(["organizer/venueDetails/"+this.equipment.venueId+"/showEquipments/"+this.equipment.venueId]);
        },
        (error)=>{
          Swal.fire("Error","Error in updating Equipment");
        }
      )
    }

}
