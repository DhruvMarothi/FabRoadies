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
  gen:string[]=["Male","Female","Other"];
  private mdlSampleIsOpen : boolean = false;
 
  constructor(private aroute : ActivatedRoute,private service : AdminService,private router:Router) { }

  ngOnInit(): void {
  
       }
       private openModal(open : boolean) : void {
        this.mdlSampleIsOpen = open;
    }

  saveEmail(email: string) {
    this.email = email;
  }

  savePhone(phone: string){
    this.phone = phone;
  }

  save(){
    this.seatLists=this.service.seatLists;
    this.bus = this.service.busObj;
    this.seatno = this.seatLists[0].seatno;
    
    this.temp.seatno = this.seatLists[this.index].seatno;
    this.psngr.push(new Passenger(this.temp.name,this.temp.gender,this.temp.age,this.temp.seatno))
    console.log(this.psngr);
    if(this.seatLists.length>1 && this.index<this.seatLists.length){
      // this.index= this.index+1;
      if(this.index<this.seatLists.length){
        this.seatno = this.seatLists[this.index].seatno;
        this.index= this.index+1;
      }
    }
    if(this.index==this.seatLists.length || this.seatLists.length==1)
      this.flag = true;

    alert(this.psngr[0].name)
  }

  save1(){
   
    
    var t= localStorage.getItem('user');
    
    if(t!=null)
    {
     this.service.uid = +t;
     
   
    for(let i=0;i<this.seatLists.length;i++){
      this.bookReq.push(new bookreq(this.service.uid,this.psngr[i].seatno,this.bus.busno,this.psngr[i].name,this.psngr[i].gender,this.psngr[i].age,this.email,this.phone));
    }
   

    this.service.br=this.bookReq;
   
    localStorage.setItem('br', JSON.stringify(this.bookReq));
    this.router.navigate(['payment-component']).then(()=>(location.reload()) );
    
   // this.service.bookReservation();
   
     }
     else{

       alert("user is not login")
    
    
       this.router.navigate(['login']).then(()=>(location.reload()) );

     }
    
    }
    

  test(){
    alert(this.email);
  }

 

}
