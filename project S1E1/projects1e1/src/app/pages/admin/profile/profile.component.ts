import { MemberService } from 'src/app/services/member.service';
import { ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  memberId:any;
  member:any
  constructor(private _route : ActivatedRoute, private memberService:MemberService) { }

  ngOnInit(): void {
    this.memberId = this._route.snapshot.params.memberId;

    this.memberService.getMember(this.memberId).subscribe(
      (data)=>{  this.member= data },
      (error)=>{ console.log(error) }
    )
  }
}
