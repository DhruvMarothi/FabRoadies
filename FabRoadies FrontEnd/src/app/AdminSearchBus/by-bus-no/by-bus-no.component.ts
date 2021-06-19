//Author Anindita Sengupta

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from 'src/app/services/admin.service';
import { BusAdmin } from 'src/BusAdmin.model';

@Component({
  selector: 'app-by-bus-no',
  templateUrl: './by-bus-no.component.html',
  styleUrls: ['./by-bus-no.component.css']
})
export class ByBusNoComponent implements OnInit {

  busno:string=" ";
  admin:BusAdmin=new BusAdmin();

  constructor(private service:AdminService,private router:Router) { }

  ngOnInit(): void {
  }

  //search by bus number
  search(){
    //this.admin=this.service.findByBusNo(this.busno) as BusAdmin;
  
    this.service.findByBusNo(this.busno).subscribe(data=>this.admin=data);
    
  }

  //logout fn
  logout(){
    this.router.navigate(['logout']);
  }

}
