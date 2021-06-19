import { Component, OnInit } from '@angular/core';
import { seat } from '../select-seat/seat.model';
import { ActivatedRoute, Router } from '@angular/router';
import { AdminService } from '../services/admin.service';
import { bookreq } from './bookingreq.model';
import { BusAdmin } from 'src/BusAdmin.model';
import { Passenger } from './passenger.model';

@Component({
  selector: 'app-enter-passenger-details',
  templateUrl: './enter-passenger-details.component.html',
  styleUrls: ['./enter-passenger-details.component.css']
})

export class EnterPassengerDetailsComponent implements OnInit {
  public flag:boolean=false;
  psngr: Passenger[]= [];
  temp: Passenger = new Passenger('','',0,'');
  seatLists : seat[] = [] ; 
  bookReq : bookreq[] = [];
  booktemp : bookreq = new bookreq(0,'','','','',0,'','');
  bus: BusAdmin= new BusAdmin();
  email: string = '';
  phone: string='';
  index: number = 0;
  gender: string='';
  seatno: string='';
  
 
  constructor(private aroute : ActivatedRoute,private service : AdminService,private router:Router) { }

  ngOnInit(): void {
    this.seatLists=this.service.seatLists;
    this.bus = this.service.busObj;
    this.seatno = this.seatLists[0].seatno;
  }

  saveEmail(email: string) {
    this.email = email;
  }

  savePhone(phone: string){
    this.phone = phone;
  }

  save(){
    
    this.temp.seatno = this.seatLists[this.index].seatno;
    this.psngr.push(new Passenger(this.temp.name,this.temp.gender,this.temp.age,this.temp.seatno))
    console.log(this.psngr);
    if(this.seatLists.length>1 && this.index<this.seatLists.length){
      this.index= this.index+1;
      if(this.index<this.seatLists.length)
        this.seatno = this.seatLists[this.index].seatno;
    }
    if(this.index==this.seatLists.length)
      this.flag = true;

    alert(this.psngr[0].name)
  }

  save1(){
    // alert(this.service.uid);
    this.router.navigate(['login']);
    
    var t= localStorage.getItem('user');
    
    if(t!=null)
    {
     this.service.uid = +t;
    } 
    // else {
    //   this.router.navigate(['login']);
    // }

    for(let i=0;i<this.seatLists.length;i++){
      this.bookReq.push(new bookreq(this.service.uid,this.psngr[i].seatno,this.bus.busno,this.psngr[i].name,this.psngr[i].gender,this.psngr[i].age,this.email,this.phone));
    }
    alert("edcre");
    console.log(this.bookReq);
    this.service.br=this.bookReq;
    this.service.bookReservation();
  }

  test(){
    alert(this.email);
  }
}
