//Author Anindita Sengupta

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BusAdmin } from 'src/BusAdmin.model';
import { AdminService } from '../services/admin.service';

@Component({
  selector: 'app-admin-bus-list',
  templateUrl: './admin-bus-list.component.html',
  styleUrls: ['./admin-bus-list.component.css']
})
export class AdminBusListComponent implements OnInit {

  bList:BusAdmin[]=[];

  constructor(private service:AdminService,private router:Router) { }

  ngOnInit(): void {
    this.service.getAdminBusList().then(data => this.bList = data);
  // this.bList=this.service.getAdminBusList();
  }

  //delete a record
  remove(busno:string){
    var ans = confirm("Are you sure to delete?");
    if(ans){
    this.service.deleteBus(busno);
    this.bList = this.bList.filter(bList => bList.busno != busno);
  }
}

  //update a record
  update(bno : string){

    this.router.navigate(['update'], {queryParams: {bno : bno}});
  }
    

  //logout fn.
  home(){
    localStorage.removeItem("admin")
    this.router.navigate(['home']).then(()=>{
      location.reload();
 });


}
}