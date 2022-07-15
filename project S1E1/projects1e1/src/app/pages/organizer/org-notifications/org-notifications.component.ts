import { Component, OnInit } from '@angular/core';
import { HistoryService } from 'src/app/services/userService/history.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-org-notifications',
  templateUrl: './org-notifications.component.html',
  styleUrls: ['./org-notifications.component.css']
})
export class OrgNotificationsComponent implements OnInit {

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
