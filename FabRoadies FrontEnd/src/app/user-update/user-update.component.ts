import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/user.model';
import { AdminService } from '../services/admin.service';

@Component({
  selector: 'app-user-update',
  templateUrl: './user-update.component.html',
  styleUrls: ['./user-update.component.css']
})
export class UserUpdateComponent implements OnInit {

  user : User = new User();


  constructor(private router:Router,private service : AdminService) { }

  ngOnInit(): void {
   
    var t= localStorage.getItem('user');
    
    if(t!=null)
    {
    
     this.user.id=+t;
    }
   
  }

  onUpdate() {

    // console.log("Your data is submitted successfully" + this.user.name +":"+ this.user.phnNo +":"+ this.user.email +":"+ this.user.password);
    this.service.updateUser(this.user);
 
    }

    //logout
    logout(){
      this.router.navigate(['home']);
    }
  
  }