import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegistrationComponent } from './pages/registration/registration.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { LoginComponent } from './pages/login/login.component';
import { HomeComponent } from './pages/home/home.component';
import { ContactusComponent } from './pages/contactus/contactus.component';
import { GalleryComponent } from './pages/gallery/gallery.component';
import{ FormsModule} from '@angular/forms'
import { HttpClientModule} from '@angular/common/http';
import { UserDashboardComponent } from './pages/user/user-dashboard/user-dashboard.component';
import { OrganizerDashboardComponent } from './pages/organizer/organizer-dashboard/organizer-dashboard.component';
import { AdminDashboardComponent } from './pages/admin/admin-dashboard/admin-dashboard.component';
import { Navbar2Component } from './components/navbar2/navbar2.component';
import { SidebarComponent } from './components/sidebar/sidebar.component';
import { SidebarAdminComponent } from './components/sidebar-admin/sidebar-admin.component';
import { SidebarOrgComponent } from './components/sidebar-org/sidebar-org.component';
import { ManageVenueComponent } from './pages/organizer/manage-venue/manage-venue.component';
import { AddVenueComponent } from './pages/organizer/add-venue/add-venue.component';
import { AddEventComponent } from './pages/organizer/add-venue/add-event/add-event.component';
import { AddFoodItemComponent } from './pages/organizer/add-venue/add-food-item/add-food-item.component';
import { AddEquipmentComponent } from './pages/organizer/add-venue/add-equipment/add-equipment.component';
import { VenueDetailsComponent } from './pages/organizer/add-venue/venue-details/venue-details.component'
import Swal from 'sweetalert2';
import { ShowEventsComponent } from './pages/organizer/add-venue/venue-details/show-events/show-events.component';
import { ShowFoodComponent } from './pages/organizer/add-venue/venue-details/show-food/show-food.component';
import { ShowEquipmentComponent } from './pages/organizer/add-venue/venue-details/show-equipment/show-equipment.component';
import { UpdateEventComponent } from './pages/organizer/add-venue/update-event/update-event.component';
import { UpdateEquipmentComponent } from './pages/organizer/add-venue/update-equipment/update-equipment.component';
import { UpdateFoodComponent } from './pages/organizer/add-venue/update-food/update-food.component';
import { ViewVenuesComponent } from './pages/user/view-venues/view-venues.component';
import { VenueDetailUserComponent } from './pages/user/venue-detail-user/venue-detail-user.component';
import { EventsUserComponent } from './pages/user/venue-detail-user/events-user/events-user.component';
import { EquipmentsUserComponent } from './pages/user/venue-detail-user/equipments-user/equipments-user.component';
import { FoodUserComponent } from './pages/user/venue-detail-user/food-user/food-user.component';
import { BookEventComponent } from './pages/user/book-event/book-event.component';
import { PayMessageComponent } from './pages/user/pay-message/pay-message.component';
import { ViewVenuesAdminComponent } from './pages/admin/view-venues-admin/view-venues-admin.component';
import { VenueDetailAdminComponent } from './pages/admin/venue-detail-admin/venue-detail-admin.component';
import { EquipmentsAdminComponent } from './pages/admin/venue-detail-admin/equipments-admin/equipments-admin.component';
import { FoodAdminComponent } from './pages/admin/venue-detail-admin/food-admin/food-admin.component';
import { EventsAdminComponent } from './pages/admin/venue-detail-admin/events-admin/events-admin.component';
import { ViewBookingsAdminComponent } from './pages/admin/view-bookings-admin/view-bookings-admin.component';
import { BookingDetailsComponent } from './pages/admin/booking-details/booking-details.component';
import { BookingHistoryUserComponent } from './pages/user/booking-history-user/booking-history-user.component';
import { BookingDetailUserComponent } from './pages/user/booking-detail-user/booking-detail-user.component';
import { PaymentComponent } from './pages/user/payment/payment.component';
import { FutureBookingComponent } from './pages/organizer/future-booking/future-booking.component';
import { BookDetailComponent } from './pages/organizer/book-detail/book-detail.component';
import { PastBookingComponent } from './pages/organizer/past-booking/past-booking.component';
import { AvailabilityComponent } from './pages/user/availability/availability.component';
import { UserNotificationComponent } from './pages/user/user-notification/user-notification.component';
import { OrgNotificationsComponent } from './pages/organizer/org-notifications/org-notifications.component';
import { ViewUserComponent } from './pages/admin/view-user/view-user.component';
import { ViewOrganizerComponent } from './pages/admin/view-organizer/view-organizer.component';
import { ProfileComponent } from './pages/admin/profile/profile.component';
import { OrgProfileComponent } from './pages/organizer/org-profile/org-profile.component';
import { UserProfileComponent } from './pages/user/user-profile/user-profile.component';
import { AdminHomeComponent } from './pages/admin/admin-home/admin-home.component';
import { OrgHomeComponent } from './pages/organizer/org-home/org-home.component';
import { UserHomeComponent } from './pages/user/user-home/user-home.component';
import { BookDetailPastComponent } from './pages/organizer/book-detail-past/book-detail-past.component';


@NgModule({
  declarations: [
    AppComponent,
    RegistrationComponent,
    NavbarComponent,
    LoginComponent,
    HomeComponent,
    ContactusComponent,
    GalleryComponent,
    UserDashboardComponent,
    OrganizerDashboardComponent,
    AdminDashboardComponent,
    Navbar2Component,
    SidebarComponent,
    SidebarAdminComponent,
    SidebarOrgComponent,
    ManageVenueComponent,
    AddVenueComponent,
    AddEventComponent,
    AddFoodItemComponent,
    AddEquipmentComponent,
    VenueDetailsComponent,
    ShowEventsComponent,
    ShowFoodComponent,
    ShowEquipmentComponent,
    UpdateEventComponent,
    UpdateEquipmentComponent,
    UpdateFoodComponent,
    ViewVenuesComponent,
    VenueDetailUserComponent,
    EventsUserComponent,
    EquipmentsUserComponent,
    FoodUserComponent,
    BookEventComponent,
    PayMessageComponent,
    ViewVenuesAdminComponent,
    VenueDetailAdminComponent,
    EquipmentsAdminComponent,
    FoodAdminComponent,
    EventsAdminComponent,
    ViewBookingsAdminComponent,
    BookingDetailsComponent,
    BookingHistoryUserComponent,
    BookingDetailUserComponent,
    PaymentComponent,
    FutureBookingComponent,
    BookDetailComponent,
    PastBookingComponent,
    AvailabilityComponent,
    UserNotificationComponent,
    OrgNotificationsComponent,
    ViewUserComponent,
    ViewOrganizerComponent,
    ProfileComponent,
    OrgProfileComponent,
    UserProfileComponent,
    AdminHomeComponent,
    OrgHomeComponent,
    UserHomeComponent,
    BookDetailPastComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
  
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
