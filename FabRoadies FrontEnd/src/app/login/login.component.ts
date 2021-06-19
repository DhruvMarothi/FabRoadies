import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Role } from 'src/role.modle';
import { User } from 'src/user.model';
import { AdminService } from '../services/admin.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: User = new User();
  flag: boolean = false;
  role: Role = new Role();

  constructor(private service: AdminService, private router: Router) { }
  ngOnInit() { }

  validate() {
    if (this.service.loginUser(this.user.email, this.user.password).subscribe(data => this.role = data)) {

      localStorage.setItem("log", "true");
      localStorage.setItem("user", this.role.userId.toString());
      if (this.role.roleId === 1) {
        localStorage.setItem("admin", "true");
        this.router.navigate(['admin-browse']).then(() => {
          location.reload();
        });
      }
      else if (this.role.roleId === 2)
      this.router.navigate(['home']).then(() => {
          location.reload();
      });
    }
  }

}
