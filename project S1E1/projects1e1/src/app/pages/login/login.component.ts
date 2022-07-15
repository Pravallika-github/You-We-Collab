import { LoginService } from './../../services/login.service';
import { Component, OnInit } from '@angular/core';
import { Router, RouterLinkActive } from '@angular/router';
import { MemberService } from 'src/app/services/member.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username="";
  password="";
  check="";
  constructor(private memberService:MemberService,private login:LoginService,private router:Router) { }

  ngOnInit(): void {}

  doLogin(){

    // Login and Navigation
    this.login.loginMember(this.username,this.password).subscribe(
      (data)=>{
        this.login.setMember(data);
        console.log(this.login.getMember());
        localStorage.setItem('memberId',data.memberId);

        if(data.role == "user"){
          this.router.navigate(['user']);
           
        }else if(data.role == "organizer"){
          this.router.navigate(['organizer']);
          
        }else if(data.role == "admin"){
          this.router.navigate(['admin']);
        };
      },
      (error)=>{
        console.log(error),
        Swal.fire("Please enter Correct Username and Password")
      }
    )
  }
}
