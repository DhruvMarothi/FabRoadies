import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/user.model';
import { AdminService } from '../services/admin.service';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {

  user: User = new User();

  constructor(private router: Router,private service : AdminService) { }

  ngOnInit(): void {
  }

  onPayment() {

    alert("Your data is submitted successfully");

  }

    //logout
    logout(){
      this.router.navigate(['home']);
    }

  }
