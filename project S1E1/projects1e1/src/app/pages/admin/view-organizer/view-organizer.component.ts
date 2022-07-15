import { Component, OnInit } from '@angular/core';
import { MemberService } from 'src/app/services/member.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-view-organizer',
  templateUrl: './view-organizer.component.html',
  styleUrls: ['./view-organizer.component.css']
})
export class ViewOrganizerComponent implements OnInit {

  organizers:any;
  constructor(private memberService : MemberService) { }

  // Get All Organizers
  ngOnInit(): void {
    this.memberService.getAllOrganizers().subscribe(
      (data)=>{
        this.organizers = data;
      },
      (error)=>{
        console.log(error);
      }
    )
  }

  }

