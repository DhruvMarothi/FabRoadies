/*
--@Author : Jaspreet--
--@Version : 1.1 { Modal for passenger details added}--
*/
import { Component, OnInit, TemplateRef } from '@angular/core';
import { seat } from 'src/app/select-seat/seat.model';
import { BsModalService } from 'ngx-bootstrap/modal';
import { BsModalRef } from 'ngx-bootstrap/modal/bs-modal-ref.service';
import { Router } from '@angular/router';
import { AdminService } from '../services/admin.service';
import { Subject } from 'rxjs';

@Component({
  selector: 'app-select-seat',
  templateUrl: './select-seat.component.html',
  styleUrls: ['./select-seat.component.css']
})
export class SelectSeatComponent implements OnInit {
  modalRef!: BsModalRef;
  

  constructor(private modalService: BsModalService,private router:Router,private service : AdminService
  ) { }

  openModal(template : TemplateRef<any>){
    this.service.seatLists = this.seatList;
    // this.router.navigate(['enter-passengers']);
    this.modalRef = this.modalService.show(template);

    
       

    modalClass: 'modal-xl';
   
  }
addSeatlist()
  {
   
    this.service.seatLists = this.seatList;


  }

  closeModal(){
    this.modalRef.hide();
  }

  close()
  {
    this.modalRef.hide();
  }
  ngOnInit(): void {
    
  }
  seatList : seat[] = [] ;                             //Array storing the final selected seats to be given to next page asking details of passengers
  seatNumberList : string[] = [];
  total = 0;
  alert = false;
  index =0;


  
  changePic( id : string){                                                              //normal to selected bus
    let x = id ;
     let prices=this.service.busObj.price  
    let seat={                                   //seat instance using iamge d
      seatno: x,
      price: prices 
               
    }

    var img_path = document.getElementById(x) as HTMLImageElement;
    if ( img_path.src.match("/assets/normalSeat1.png")){
      if( this.seatList.length != 6){
          img_path.src="../assets/selectedSeat.png";                   
          this.updateSeatList(seat);       // Will update selected seat in list
          this.updatePriceAdd(seat.price);    // Will update total price of booked tickets
          this.updateSeatNumberlist(seat.seatno);
          this.index++;
      }
      else{
        this.alert = true;
      }
    }
      else {
        if ( img_path.src.match("/assets/selectedSeat.png")){                 //selected to normal
          img_path.src="/assets/normalSeat1.png";
          this.updatePriceSub(seat.price);
          this.downdateSeatList(seat.seatno);
          this.index--;
        } 
     }
   }


  updatePriceAdd( price : number){                            //Add price of selected seat to total price
    this.total += price ;
 }

  updatePriceSub( price : number){
    this.total -= price;
  }

 updateSeatList( selectedSeat : seat ){                   // Add selected seat to seatList array
   this.seatList.push(selectedSeat);
 }

 updateSeatNumberlist( id : string){
   this.seatNumberList.push(id);
 }

  downdateSeatList(id : string){                           //Function to de-select seats
    var x = id;
    var i : any;
    for (i in this.seatNumberList){
      if ( this.seatNumberList[i] == x){
        break;
      }
    }
    if(i==0){
       this.seatList.shift();
       this.seatNumberList.shift();
    }
    else{
      this.seatList.splice(i ,1);
      this.seatNumberList.splice(i,1);
    }

  }
}