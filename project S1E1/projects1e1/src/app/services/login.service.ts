import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private httpClient: HttpClient, private router :Router) { }

// Login Member
  public loginMember(username:any,password:any):Observable<any>{
    return this.httpClient.get(`${baseUrl}/member/${username}/${password}`);
  }

  // Set Member to Local Storage
  setMember(data:any){
    localStorage.setItem('localMember',JSON.stringify(data));
  };

  // Check if User is Logged In
  public isLoggedIn(){
    let memberStr = localStorage.getItem("localMember");
    if (memberStr==null || memberStr=='' || memberStr==undefined ){
      return false;
    }else{
      return true;
    }
  }

// LogOut
  public logOut(){
    localStorage.removeItem("localMember");
    this.router.navigate(['login']);
  
  }

  // Get Member from LocalStorage
  public getMember(){
    let memberStr = localStorage.getItem("localMember");
    if(memberStr != null){
      return JSON.parse(memberStr);
    }else{
      this.logOut();
    }
  }

  // Get Member Id from LocalStorage
  public getMemberId(){
    return localStorage.getItem('memberId');
  }

}
