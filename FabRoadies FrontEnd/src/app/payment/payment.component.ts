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

  bookreq()
  {
    var t = (localStorage.getItem('br'));
    if(t!=null)
    {
     this.service.br = JSON.parse(t);
    } 
    console.log(this.service.br[0].busno);
   this.service.bookReservation();
    alert("Payment Successfully Completed");
  }
  
  }
