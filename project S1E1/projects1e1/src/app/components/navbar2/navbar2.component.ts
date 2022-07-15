import { LoginService } from './../../services/login.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navbar2',
  templateUrl: './navbar2.component.html',
  styleUrls: ['./navbar2.component.css']
})
export class Navbar2Component implements OnInit {

  role ="";
  firstName="";

  constructor(private login:LoginService) {
    this.role = this.login.getMember().role;
    this.firstName = this.login.getMember().firstName;
   }

  ngOnInit(): void {
  }

  logout(){
    this.login.logOut();
  }

}
