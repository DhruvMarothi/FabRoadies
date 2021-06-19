import { Component, OnInit } from '@angular/core';
import { AdminService } from '../services/admin.service';
import { Passenger } from '../enter-passenger-details/passenger.model';

@Component({
  selector: 'app-passenger-list',
  templateUrl: './passenger-list.component.html',
  styleUrls: ['./passenger-list.component.css']
})
export class PassengerListComponent implements OnInit {
  passenger: Passenger[] = [];

  constructor(private service:AdminService) { }

  ngOnInit(): void {
    this.service.getPassengerList().then(data => this.passenger = data);
    // this.passenger=this.service.pList;
  }

}
