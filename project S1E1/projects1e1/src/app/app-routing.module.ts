import { BookDetailPastComponent } from './pages/organizer/book-detail-past/book-detail-past.component';
import { VenueDetailAdminComponent } from './pages/admin/venue-detail-admin/venue-detail-admin.component';
import { UserHomeComponent } from './pages/user/user-home/user-home.component';
import { OrgHomeComponent } from './pages/organizer/org-home/org-home.component';
import { AdminHomeComponent } from './pages/admin/admin-home/admin-home.component';
import { OrgProfileComponent } from './pages/organizer/org-profile/org-profile.component';
import { ViewOrganizerComponent } from './pages/admin/view-organizer/view-organizer.component';
import { ViewUserComponent } from './pages/admin/view-user/view-user.component';

import { UserNotificationComponent } from './pages/user/user-notification/user-notification.component';
import { AvailabilityComponent } from './pages/user/availability/availability.component';
import { BookDetailComponent } from './pages/organizer/book-detail/book-detail.component';
import { FutureBookingComponent } from './pages/organizer/future-booking/future-booking.component';
import { PaymentComponent } from './pages/user/payment/payment.component';
import { BookingDetailUserComponent } from './pages/user/booking-detail-user/booking-detail-user.component';
import { BookingHistoryUserComponent } from './pages/user/booking-history-user/booking-history-user.component';
import { BookingDetailsComponent } from './pages/admin/booking-details/booking-details.component';
import { ViewBookingsAdminComponent } from './pages/admin/view-bookings-admin/view-bookings-admin.component';
import { ViewVenuesAdminComponent } from './pages/admin/view-venues-admin/view-venues-admin.component';
import { PayMessageComponent } from './pages/user/pay-message/pay-message.component';
import { BookEventComponent } from './pages/user/book-event/book-event.component';
import { EquipmentsUserComponent } from './pages/user/venue-detail-user/equipments-user/equipments-user.component';
import { FoodUserComponent } from './pages/user/venue-detail-user/food-user/food-user.component';
import { VenueDetailUserComponent } from './pages/user/venue-detail-user/venue-detail-user.component';
import { ViewVenuesComponent } from './pages/user/view-venues/view-venues.component';
import { ShowFoodComponent } from './pages/organizer/add-venue/venue-details/show-food/show-food.component';
import { ShowEquipmentComponent } from './pages/organizer/add-venue/venue-details/show-equipment/show-equipment.component';
import { ShowEventsComponent } from './pages/organizer/add-venue/venue-details/show-events/show-events.component';
import { VenueDetailsComponent } from './pages/organizer/add-venue/venue-details/venue-details.component';
import { AddFoodItemComponent } from './pages/organizer/add-venue/add-food-item/add-food-item.component';
import { AddEquipmentComponent } from './pages/organizer/add-venue/add-equipment/add-equipment.component';
import { AddEventComponent } from './pages/organizer/add-venue/add-event/add-event.component';
import { AddVenueComponent } from './pages/organizer/add-venue/add-venue.component';
import { ManageVenueComponent } from './pages/organizer/manage-venue/manage-venue.component';
import { OrganizerGuard } from './services/organizerService/organizer.guard';
import { OrganizerDashboardComponent } from './pages/organizer/organizer-dashboard/organizer-dashboard.component';
import { UserDashboardComponent } from './pages/user/user-dashboard/user-dashboard.component';
import { LoginComponent } from './pages/login/login.component';
import { HomeComponent } from './pages/home/home.component';
import { ContactusComponent } from './pages/contactus/contactus.component';
import { GalleryComponent } from './pages/gallery/gallery.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegistrationComponent } from './pages/registration/registration.component';
import { UserGuard } from './services/userService/user.guard';
import { AdminGuard } from './services/adminService/admin.guard';
import { AdminDashboardComponent } from './pages/admin/admin-dashboard/admin-dashboard.component';
import { UpdateEquipmentComponent } from './pages/organizer/add-venue/update-equipment/update-equipment.component';
import { UpdateFoodComponent } from './pages/organizer/add-venue/update-food/update-food.component';
import { UpdateEventComponent } from './pages/organizer/add-venue/update-event/update-event.component';
import { EventsUserComponent } from './pages/user/venue-detail-user/events-user/events-user.component';
import { PastBookingComponent } from './pages/organizer/past-booking/past-booking.component';
import { OrgNotificationsComponent } from './pages/organizer/org-notifications/org-notifications.component';
import { ProfileComponent } from './pages/admin/profile/profile.component';
import { UserProfileComponent } from './pages/user/user-profile/user-profile.component';

const routes: Routes = [
  
  {
    path:"registration",
    component:RegistrationComponent
  },
 

  {
    path:"",
    component:HomeComponent
  },
  

  {
    path:"contactus",
    component:ContactusComponent
  },
  {
    path:"gallery",
    component:GalleryComponent
  },
  {
    path:"login",
    component:LoginComponent,  
  },

  {
    path:"user",
    component:UserDashboardComponent,
    canActivate:[UserGuard],
    children:[
      {
        path:"",
        component:UserHomeComponent,
      },

      {
        path:"viewVenues",
        component:ViewVenuesComponent,
      },
      {
        path:"venueDetails/:venueId",
        component:VenueDetailUserComponent,
        children:[
          {
            path:"events/:venueId",
            component:EventsUserComponent,
          },
          {
            path:"foodItems/:venueId",
            component:FoodUserComponent,
          },
          {
            path:"equipments/:venueId",
            component:EquipmentsUserComponent,
          },
        ]        
      },
      {
        path:"availability/:venueId",
        component:AvailabilityComponent,
      },
      {
        path:"bookEvent",
        component:BookEventComponent,
      },
      {
        path:"payMessage",
        component:PayMessageComponent,

      },
      {
        path:"bookingHistory",
        component:BookingHistoryUserComponent,
      },
      {
        path:"bookingDetail/:bookingId",
        component:BookingDetailUserComponent,
      },
      {
        path:"payment/:bookingId",
        component:PaymentComponent,
      },
      {
        path:"notifications",
        component:UserNotificationComponent,
      },
      {
        path:"userProfile",
        component:UserProfileComponent,
      },
  ]
  },

  {
    path:"organizer",
    component:OrganizerDashboardComponent,
    canActivate:[OrganizerGuard],
    children:[
      {
        path:"",
        component:OrgHomeComponent,
      },

    {
      path:"manageVenue",
      component:ManageVenueComponent,
    },
    {
      path:"addVenue",
      component:AddVenueComponent,
    },


    { path:"venueDetails/:venueId",
      component:VenueDetailsComponent,
      children:[
        {
          path:"showEvents/:venueId",
          component:ShowEventsComponent,
        },

        {
          path:"showFoodItems/:venueId",
          component:ShowFoodComponent,
        },

        {
          path:"showEquipments/:venueId",
          component:ShowEquipmentComponent,
        },

        {
          path:"addEvent/:venueId",
          component:AddEventComponent,
        },

        {
          path:"addFoodItem/:venueId",
          component:AddFoodItemComponent,
        },

        {
          path:"addEquipment/:venueId",
          component:AddEquipmentComponent,
        },


        {
          path:"updateEvent/:eventId",
          component:UpdateEventComponent,
        },

        {
          path:"updateFoodItem/:foodItemId",
          component:UpdateFoodComponent,
        },

        {
          path:"updateEquipment/:equipmentId",
          component:UpdateEquipmentComponent,
        }

      ]
    },
    {
      path:"viewBookings",
      component:FutureBookingComponent,
    },
    {
      path:"pastBookings",
      component:PastBookingComponent,
    },
    {
      path:"bookDetailsF/:bookingId",
      component:BookDetailComponent,
    },
    {
      path:"bookDetailsP/:bookingId",
      component:BookDetailPastComponent,
    },
    {
      path:"notifications",
      component:OrgNotificationsComponent,
    },
    {
      path:"orgProfile",
      component:OrgProfileComponent,
    },
    
  ],
  },
  {
    path:"admin",
    component:AdminDashboardComponent,
    canActivate:[AdminGuard],
    children:[
      {
        path:"",
        component:AdminHomeComponent,
      },
      {
        path:"viewVenues",
        component:ViewVenuesAdminComponent,
      },
      {
        path:"venueDetails/:venueId",
        component:VenueDetailAdminComponent,
        children:[
          {
            path:"events/:venueId",
            component:EventsUserComponent,
          },
          {
            path:"foodItems/:venueId",
            component:FoodUserComponent,
          },
          {
            path:"equipments/:venueId",
            component:EquipmentsUserComponent,
          },
        ]        
      },
      {
        path:"viewBookings",
        component:ViewBookingsAdminComponent,
      },
      {
        path:"bookingDetails/:bookingId",
        component:BookingDetailsComponent,
      },
      {
        path:"allUsers",
        component:ViewUserComponent,
      },
      {
        path:"allOrganizers",
        component:ViewOrganizerComponent,
      },
      {
        path:"profile/:memberId",
        component:ProfileComponent,
      },
      
    ]
  },

  {
    path:"home",
    component:HomeComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
