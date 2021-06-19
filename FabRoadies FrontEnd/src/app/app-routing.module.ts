import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminBrowseComponent } from './admin-browse/admin-browse.component';
import { AdminBusListComponent } from './admin-bus-list/admin-bus-list.component';
import { BrowseComponent } from './browse/browse.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { NoBusesFoundComponent } from './no-buses-found/no-buses-found.component';
import { AddBusComponent } from './add-bus/add-bus.component';
import { ByBusNoComponent } from './AdminSearchBus/by-bus-no/by-bus-no.component';
import { UpdateComponent } from './update/update.component';
import { TicketListComponent } from './ticket-list/ticket-list.component';
import { CancelTripComponent } from './cancel-trip/cancel-trip.component';
import { TicketBookingPageComponent } from './ticket-booking-page/ticket-booking-page.component';
import { EnterPassengerDetailsComponent } from './enter-passenger-details/enter-passenger-details.component';
import { PassengerListComponent } from './passenger-list/passenger-list.component';
import { UserUpdateComponent } from './user-update/user-update.component';


const routes: Routes = [
  {path:'',component:BrowseComponent},
  {path:'home',component:BrowseComponent},
  {path:'login',component:LoginComponent},
  {path:'signup',component:SignupComponent},
  {path:'admin-browse',component:AdminBrowseComponent},
  {path:'add-bus',component:AddBusComponent},
  {path:'admin_bus-list',component:AdminBusListComponent},
  {path:'search',component:ByBusNoComponent},
  {path:'update',component:UpdateComponent},
  {path :'no-bus', component:NoBusesFoundComponent},
  {path :'mytrip', component:TicketListComponent},
  {path:"cancletrip",component:CancelTripComponent},
  {path :'book-ticket', component:TicketBookingPageComponent},
  {path: 'enter-passengers', component: EnterPassengerDetailsComponent},
  {path: 'passenger-list', component: PassengerListComponent},
  {path:'user-update',component:UserUpdateComponent},

  {path:'**',redirectTo:'home',pathMatch:'full'},
 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
