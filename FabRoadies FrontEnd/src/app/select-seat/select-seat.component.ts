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

@Component({
  selector: 'app-select-seat',
  templateUrl: './select-seat.component.html',
  styleUrls: ['./select-seat.component.css']
})
export class SelectSeatComponent implements OnInit {
  modalRef!: BsModalRef;

  constructor(
    private modalService: BsModalService,private router:Router,private service : AdminService
  ) { }

  openModal(template : TemplateRef<any>){
    this.service.seatLists = this.seatList;
    // this.router.navigate(['enter-passengers']);
    this.modalRef = this.modalService.show(template);
    modalClass: 'modal-xl';
  }

  closeModal(){
    this.modalRef.hide();
  }

  ngOnInit(): void {
  }
  seatList : seat[] = [] ;                             //Array storing the final selected seats to be given to next page asking details of passengers
  total = 0;
  alert = false;


  changePic( id : string){                                                              //normal to selected bus
    let x = id ;
    var img_path = document.getElementById(x) as HTMLImageElement;
    if ( img_path.src.match("/assets/normalSeat1.png")){
      if( this.seatList.length != 6){
          img_path.src="../assets/selectedSeat.png";
          

          let seat={                                   //seat instance using iamge d
            seatno: x,
            price: 200                 //this.bus.price  To be made dynamic from bus component from which seats are being viewed
          }

          this.updateSeatList(seat);       // Will update selected seat in list
          this.updatePriceAdd(seat.price);    // Will update total price of booked tickets

      }
      else{
        this.alert = true;
      }
    }
  }
    // else {
    //    if ( img_path.src.match("/assets/selectedSeat.png")){                 //selected to normal
    //      //img_path.src = "/assets/selectedSeat.png";
    //      //img_path.innerHTML = `<img src="/assets/selectedSeat.png">`
    //      img_path.src="/assets/normalSeat1.png";

    //      let seat={                                   //seat instance using iamge d
    //       seatno: x,
    //       price: 200                 //this.bus.price  To be made dynamic from bus component from which seats are being viewed
    //     }

         
    //      document.getElementById("T").deleteRow("x");
    //      this.updatePriceSub(seat.price);
    //      this.downdateSeatList();
  //      } 
  //   }
  // }


      updatePriceAdd( price : number){                            //Add price of selected seat to total price
        this.total += price ;
     }

    //  updatePriceSub( price : number){
    //    this.total -= price;
    //  }

     updateSeatList( selectedSeat : seat ){                   // Add selected seat to seatList array
       this.seatList.push(selectedSeat);
     }

    //  seatTransfer(){
    //   // alert(this.seatList[0].seatno);
    // }

    //  downdateSeatList(){
    //    this.seatList.pop;
    //  }
}

  
