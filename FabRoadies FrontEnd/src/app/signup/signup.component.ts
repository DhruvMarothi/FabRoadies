import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/user.model';
import { AdminService } from '../services/admin.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  user : User = new User();
  flag : boolean = false;

  constructor(private service:AdminService, private router:Router) { }

  ngOnInit(): void {
  }

  onSubmit() {
  //  console.log("Your data is submitted successfully" + this.user.name +":"+ this.user.phnNo +":"+ this.user.email +":"+ this.user.password);
  
  this.service.addUser(this.user);
  alert("Your data is submitted successfully");
  this.router.navigate(['home']);

  
  }

}
