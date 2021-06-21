//Author Anindita Sengupta

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BusAdmin } from 'src/BusAdmin.model';
import Busquery from 'src/busQuery.model';
import { User } from 'src/user.model';
import { AdminService } from '../services/admin.service';

@Component({
  selector: 'app-browse',
  templateUrl: './browse.component.html',
  styleUrls: ['./browse.component.css']
})
export class BrowseComponent implements OnInit {

  public feedBack:string='';

  user:User=new User();
  busq:Busquery=new Busquery();
  date: string = '';
  busl:BusAdmin[]=[];
  destination : string[] = ["Kolkata","Chennai","Pune","Mumbai","Bangalore","Delhi"];
  source : string[] = ["Kolkata","Chennai","Pune","Mumbai","Bangalore","Delhi"];

  constructor(private service:AdminService,private router:Router) { }

  ngOnInit(): void {
    this.date = new Date().toISOString().slice(0, 10);//To get Today's Date
    // alert(this.date)
  }

  //feedback data
  feedback(){
    alert('Thanks for the feedback!');
    console.log(this.user.name+" has "+this.user.email+" and "+this.user.phoneNumber);
    console.log("FeedBack:" +this.feedBack);
   }
   
   searchBusBysdd(busq:Busquery)
   {
    
    this.router.navigate(['book-ticket'], {queryParams: {src :this.busq.source,dest:this.busq.destination,date:this.busq.dateOfDeparture }});
   }
}
