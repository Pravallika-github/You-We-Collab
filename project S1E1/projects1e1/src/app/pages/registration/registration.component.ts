import { MemberService } from './../../services/member.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  public member={
    memberId :'',
    role:'Select Role',
    firstName:'',
    lastName:'',
    phoneNumber:'',
    email:'',
    password:''
  }

  public confirmPassword="";

  constructor(private memberService : MemberService, private router:Router) { }

  ngOnInit(): void {
  }

  // Registration Method
  doRegistration(){

    if(!(this.member.password == this.confirmPassword)){
      alert("Password and confirm password does not match");
      return;
    }
    this.memberService.addMember(this.member).subscribe(
      (data)=>{
        console.log(data);
        Swal.fire("Success","Your registration is successful","success");
        this.router.navigate(['login']);
      },
      (error)=>{
        console.log(error),
        Swal.fire("Error","This Email or password already taken","error");
      }
    )


  }

// Validation for Select Field
  roleHasError=true;
  validateRole(value: string){
    if (value==="Select Role"){
      this.roleHasError=true;
    }
    else{
      this.roleHasError=false;
    }
  }

}
