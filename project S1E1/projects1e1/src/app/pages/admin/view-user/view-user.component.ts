import { MemberService } from 'src/app/services/member.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-view-user',
  templateUrl: './view-user.component.html',
  styleUrls: ['./view-user.component.css']
})
export class ViewUserComponent implements OnInit {

  users:any;
  constructor(private memberService : MemberService) { }

  ngOnInit(): void {
    // Get All Users
    this.memberService.getAllUsers().subscribe(
      (data)=>{
        this.users = data;
      },
      (error)=>{
        console.log(error);
      }
    )
  }

}
