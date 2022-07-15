import { MemberService } from 'src/app/services/member.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  memberId:any;
  member:any;
  constructor(private memberService : MemberService) { }

  ngOnInit(): void {
    this.memberId = localStorage.getItem('memberId');

    this.memberService.getMember(this.memberId).subscribe(
      (data)=>{  this.member= data },
      (error)=>{ console.log(error) }
    )
  }

}
