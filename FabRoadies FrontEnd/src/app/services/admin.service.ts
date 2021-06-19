//Author Anindita Sengupta

import { Injectable } from '@angular/core';
import { BusAdmin } from 'src/BusAdmin.model';
import { HttpClient } from '@angular/common/http';
import { delay } from 'rxjs/operators';
import { User } from 'src/user.model';
import { Role } from 'src/role.modle';
import { Ticket } from 'src/Ticket.model';
import Busquery from 'src/busQuery.model';
import { seat } from '../select-seat/seat.model';
import { bookreq } from '../enter-passenger-details/bookingreq.model';
import { Passenger } from '../enter-passenger-details/passenger.model';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  bus: BusAdmin[] = [];
  busObj: BusAdmin = new BusAdmin();
  baseUrl: string = "http://localhost:8080";
  uid: number = 0;
  bq: Busquery = new Busquery();
  seatLists: seat[] = [];
  br : bookreq[] = [];
  booktemp: bookreq = new bookreq(0,'','','','',0,'','');
  pList:Passenger[]=[];
  tid:number = 0;

  constructor(private http: HttpClient) { }

  addAdminBus(addBus: BusAdmin) {
    this.http.post(this.baseUrl + "/admin/addBus", addBus).subscribe(data => data = addBus);
  }

  async  getAdminBusList() {
    return await this.http.get<BusAdmin[]>(this.baseUrl + "/admin/showAllBuses").toPromise();
  }

  async  getPassengerList() {
    return await this.http.get<Passenger[]>(this.baseUrl + "/get/Passengers/"+this.tid).toPromise();
  }

  deleteBus(busno: string) {
    this.http.delete(this.baseUrl + "/admin/deleteBus/" + busno).subscribe();
  }

  deleteTicket(ticketId: number) {
    this.http.delete(this.baseUrl + "/delete/" + ticketId).subscribe();
  }

  findByBusNo(busno: string) {

    return this.http.get<BusAdmin>(this.baseUrl + "/get/bus/" + busno);
    // return this.busList.find(x=>x.busno==busno);
  }

  updateBus(addBus: BusAdmin) {
    this.http.put(this.baseUrl + "/bus/edit", addBus).subscribe();
  }
  
  addUser(user: User) {
    this.http.post(this.baseUrl + "/add/2", user).subscribe();
  }
  
  loginUser(email: string, password: string) {
    return this.http.get<Role>(this.baseUrl + "/login/" + email + "/" + password);
  }

  async gettickets() {
    return await this.http.get<Ticket[]>(this.baseUrl + "/get/userTickets/" + localStorage.getItem("user")).toPromise();
  }

  cancelTrip(tid: string) {
    this.http.delete(this.baseUrl + "/delete/" + tid).subscribe();
  }

  findbus(src: string, dest: string, date: string) {

    this.bq.source = src;
    this.bq.destination = dest;
    this.bq.dateOfDeparture = date;
    
    return this.http.post<BusAdmin[]>(this.baseUrl + "/findBuses", this.bq);
  }

  bookReservation(){
    // this.booktemp.userid=171;
    // this.booktemp.busno="DM01";
    // this.booktemp.name="Dhruv";
    // this.booktemp.gender="Male";
    // this.booktemp.age=23;
    // this.booktemp.seatno="A1";
    // this.booktemp.email="Dhruv@gmail.com";
    // this.booktemp.phone="876560964";
    // this.br.push(this.booktemp);
    // alert(this.br[1].name);
    this.http.post(this.baseUrl + "/completeReservation", this.br).subscribe();
    // console.log(this.br);
  }

}
