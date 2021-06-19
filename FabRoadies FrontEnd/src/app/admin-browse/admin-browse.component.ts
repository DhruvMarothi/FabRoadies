import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-browse',
  templateUrl: './admin-browse.component.html',
  styleUrls: ['./admin-browse.component.css']
})
export class AdminBrowseComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit(): void {
  }

  //logout fn.
  home(){
    localStorage.removeItem("admin")
    this.router.navigate(['home']).then(()=>{
      location.reload();
 });

  }

}
