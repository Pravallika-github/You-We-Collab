import { ActivatedRoute, Router } from '@angular/router';
import { EquipmentOrgService } from './../../../../services/organizerService/eventServiceOrg/equipment-org.service';
import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-add-equipment',
  templateUrl: './add-equipment.component.html',
  styleUrls: ['./add-equipment.component.css']
})
export class AddEquipmentComponent implements OnInit {

  equipment:any={
    equipmentId:null,
    equipmentName:null,
    equipmentCost:null,
    venueId:null
  }

  constructor(private eqService:EquipmentOrgService, private _route:ActivatedRoute,
    private route:Router) { }

  ngOnInit(): void {
    this.equipment.venueId = this._route.snapshot.params.venueId;
  }

  addEquipment(){
    this.eqService.addNewEquipment(this.equipment).subscribe(
      (data)=>{
        this.equipment.equipmentName=null;this.equipment.equipmentCost=null;
        this.route.navigate(["organizer/venueDetails/"+this.equipment.venueId+"/showEquipments/"+this.equipment.venueId]);
      },
      (error)=>{
        Swal.fire("Error","Problem in adding Equipment","error");
      }
    );
  }

}
