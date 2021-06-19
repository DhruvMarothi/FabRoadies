import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from '../services/admin.service';

@Component({
  selector: 'app-cancel-trip',
  templateUrl: './cancel-trip.component.html',
  styleUrls: ['./cancel-trip.component.css']
})
export class CancelTripComponent implements OnInit {

  tid:string='';
  constructor(private service:AdminService,private router:Router) { }

  ngOnInit(): void {
  }
  cancel()
  {
    this.service.cancelTrip(this.tid);
    this.router.navigate(['home'])
  }

}
