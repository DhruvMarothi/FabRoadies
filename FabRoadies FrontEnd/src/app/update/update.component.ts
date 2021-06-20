import { Component, OnInit } from '@angular/core';
import { ActivatedRoute,Router } from '@angular/router';
import { BusAdmin } from 'src/BusAdmin.model';
import { AdminService } from '../services/admin.service';
import { filter } from 'rxjs/operators';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {

  addBus : BusAdmin = new BusAdmin();

  source : string[] = ["Kolkata","Chennai","Pune","Mumbai","Bangalore","Delhi"];

  destination : string[] = ["Kolkata","Chennai","Pune","Mumbai","Bangalore","Delhi"]

  busType:string[]=["AC","Non-AC"]

  constructor(private service:AdminService, private router:Router, private aroute : ActivatedRoute) { }

  ngOnInit(): void {

    this.aroute.queryParams.pipe(filter(params => params.bno)).subscribe(params => {
      var pbno = params.bno;
      this.service.findByBusNo(pbno).subscribe(data => this.addBus = data);
    })
  }

  update() {
    this.service.updateBus(this.addBus);
    this.router.navigate(['admin_bus-list']).then(()=>location.reload());
  } 

  

}
