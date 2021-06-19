import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from './services/admin.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  public flag:boolean=false;
  public log:boolean=false;
  title = 'FabRoadies';
  constructor(private service:AdminService,private router:Router) { }
ngOnInit():void{

  

    if(localStorage.getItem("admin")!=null)
    {
      this.flag=true;
    }
    else{
      this.flag=false;
    } 
    if(localStorage.getItem("log")!=null) 
    {
      this.log=true;
    }
    else{
      this.log=false;
    } 
  
  }    

  
  logout()
  {
    if(localStorage.getItem("admin")!=null)
    {
      localStorage.removeItem("admin")
      this.router.navigate(['home']).then(()=>{
        location.reload();
       });
    }
    localStorage.removeItem("log");
    this.router.navigate(['home']).then(()=>{
      location.reload();
     });
 
}
home()
{
  localStorage.removeItem("admin")
  this.router.navigate(['home']).then(()=>{
    location.reload();
   }); 
}

}