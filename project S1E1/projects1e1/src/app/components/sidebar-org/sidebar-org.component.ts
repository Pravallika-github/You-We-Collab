import { Router } from '@angular/router';
import { OrganizerService } from './../../services/organizerService/organizer.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-sidebar-org',
  templateUrl: './sidebar-org.component.html',
  styleUrls: ['./sidebar-org.component.css']
})
export class SidebarOrgComponent implements OnInit {

  constructor(private orgService: OrganizerService,private router:Router) { }
 
  ngOnInit(): void {
  }

}
