import { HistoryService } from './../../../services/userService/history.service';
import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-user-notification',
  templateUrl: './user-notification.component.html',
  styleUrls: ['./user-notification.component.css']
})
export class UserNotificationComponent implements OnInit {


  notifications:any;
  constructor(private historyService : HistoryService) { }

  ngOnInit(): void {

    this.historyService.getNotifications().subscribe(
      (notifications:any)=>{
        this.notifications = notifications;
      },
      (error)=>{
        Swal.fire("Error","Problem in loading Notifications","error");
      }
      )
  }

  public deleteNoti(notificationId:any){
    this.historyService.deleteNoti(notificationId).subscribe(
      (data)=>{
        this.notifications = this.notifications.filter((notification:any)=>notification.notificationId!=notificationId);
      },
      (error)=>{console.log(error)}
    )
  }

}
