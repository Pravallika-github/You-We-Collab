import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import baseUrl from './helper';


@Injectable({
  providedIn: 'root'
})

export class MemberService {

  constructor(private httpClient: HttpClient) { }
  //// this method is endpoint, and post a request  for adding member
  //// to the database
  public addMember(member : any ){
    return this.httpClient.post(`${baseUrl}/member/add`, member);
  }

  ///List of Users
  public getAllUsers(){
    return this.httpClient.get(`${baseUrl}/member/getAllUsers`);
  }

  ///List of Organizers
  public getAllOrganizers(){
    return this.httpClient.get(`${baseUrl}/member/getAllOrganizers`);
  }

  //get member by memberId
  public getMember(memberId:any){
    return this.httpClient.get(`${baseUrl}/member/getMember/${memberId}`);
  }

  ///delete Member
  public deleteMember(memberId:any){
    return this.httpClient.delete(`${baseUrl}/member/deleteMember/${memberId}`);
  }

}