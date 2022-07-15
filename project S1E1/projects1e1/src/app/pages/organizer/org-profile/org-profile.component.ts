import { MemberService } from 'src/app/services/member.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-org-profile',
  templateUrl: './org-profile.component.html',
  styleUrls: ['./org-profile.component.css']
})
export class OrgProfileComponent implements OnInit {

  memberId:any;
  member:any;
  constructor(private memberService : MemberService) { }

  ngOnInit(): void {

    this.memberId = localStorage.getItem('memberId');

    // Get Member for Profile
    this.memberService.getMember(this.memberId).subscribe(
      (data)=>{  this.member= data },
      (error)=>{ console.log(error) }
    )
    
  }

}
