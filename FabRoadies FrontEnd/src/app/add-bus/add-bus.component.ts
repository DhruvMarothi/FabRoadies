//Author Sanchari 

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BusAdmin } from 'src/BusAdmin.model';
import { AdminService } from '../services/admin.service';

@Component({
  selector: 'app-add-bus',
  templateUrl: './add-bus.component.html',
  styleUrls: ['./add-bus.component.css']
})
export class AddBusComponent implements OnInit {

  addBus : BusAdmin = new BusAdmin();
  source : string[] = ["Kolkata","Chennai","Pune","Mumbai","Bangalore","Delhi"];
  destination : string[] = ["Kolkata","Chennai","Pune","Mumbai","Bangalore","Delhi"]
  busType:string[]=["AC","Non-AC"]

  constructor(private service:AdminService, private router:Router) { }

  ngOnInit(): void {
  }

  save(){
    this.service.addAdminBus(this.addBus);
    console.log("Saving...." + this.addBus.busno);
    alert("Your entry is saved successfully");
    this.router.navigate(['admin_bus-list']);
  }

   //logout function
   logout(){
    this.router.navigate(['home']);
  }

}