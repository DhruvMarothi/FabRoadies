import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from'@angular/common/http';
import { FormsModule } from '@angular/forms';

// import { MatButtonModule } from '@angular/material/button';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatButtonModule } from '@angular/material/button';
import { ModalModule } from 'node_modules/ngx-bootstrap/modal';

import { AppComponent } from './app.component';
import { BrowseComponent } from './browse/browse.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { AdminBrowseComponent } from './admin-browse/admin-browse.component';
import { AddBusComponent } from './add-bus/add-bus.component';
import { NoBusesFoundComponent } from './no-buses-found/no-buses-found.component';
import { AdminBusListComponent } from './admin-bus-list/admin-bus-list.component';
import { TicketBookingPageComponent } from './ticket-booking-page/ticket-booking-page.component';
import { ByBusNoComponent } from './AdminSearchBus/by-bus-no/by-bus-no.component';
import { UpdateComponent } from './update/update.component';
import { TicketListComponent } from './ticket-list/ticket-list.component';
import { CancelTripComponent } from './cancel-trip/cancel-trip.component';
import { EnterPassengerDetailsComponent } from './enter-passenger-details/enter-passenger-details.component';
import { SelectSeatComponent } from './select-seat/select-seat.component';
import { PassengerListComponent } from './passenger-list/passenger-list.component';


@NgModule({
  declarations: [
    AppComponent,
    BrowseComponent,
    LoginComponent,
    SignupComponent,
    AdminBrowseComponent,
    AddBusComponent,
    NoBusesFoundComponent,
    AdminBusListComponent,
    TicketBookingPageComponent,
    ByBusNoComponent,
    UpdateComponent,
    TicketListComponent,
    CancelTripComponent,
    TicketBookingPageComponent,
    SelectSeatComponent,
    EnterPassengerDetailsComponent,
    PassengerListComponent,
 
  ],

  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatButtonModule,
    ModalModule.forRoot()
    // MatButtonModule
  ],

  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
