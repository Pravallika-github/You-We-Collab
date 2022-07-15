import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { EquipmentOrgService } from 'src/app/services/organizerService/eventServiceOrg/equipment-org.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-equipments-admin',
  templateUrl: './equipments-admin.component.html',
  styleUrls: ['./equipments-admin.component.css']
})
export class EquipmentsAdminComponent implements OnInit {

  venueId=0;
  equipments:any;

  constructor(private _route:ActivatedRoute, private _service:EquipmentOrgService) { }

  ngOnInit(): void {

    this.venueId = this._route.snapshot.params.venueId;
  
    // Get List of Equipments
     this._service.getEquipmentsByVenueId(this.venueId).subscribe(
       (equipments)=>{ this.equipments = equipments; },
       (error)=>{ Swal.fire("Something went Wrong"); }
      );
  }
}
