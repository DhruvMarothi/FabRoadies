import { Component, OnInit, TemplateRef} from '@angular/core';
import { Router } from '@angular/router';
import { BsModalService } from 'ngx-bootstrap/modal';
import { BsModalRef } from 'ngx-bootstrap/modal/bs-modal-ref.service';
import { Ticket } from 'src/Ticket.model';
import { AdminService } from '../services/admin.service';
import { Passenger } from '../enter-passenger-details/passenger.model';

@Component({
  selector: 'app-ticket-list',
  templateUrl: './ticket-list.component.html',
  styleUrls: ['./ticket-list.component.css']
})
export class TicketListComponent implements OnInit {

  modalRef!: BsModalRef;
  tList: Ticket[] = [];
  upList: Ticket[] = [];
  pastList: Ticket[] = [];
  pList:Passenger[]=[];
  up: boolean = true;
  past: boolean = true;
  tid:number = 0;

  constructor(private modalService: BsModalService,private service: AdminService, private router: Router) { }

  ngOnInit(): void {
    this.service.gettickets().then(data => this.tList = data);
    //this.tBus[0]=this.tList[0].bus;
    // console.log(this.tList[0])

  }

  showUpcoming() {
    // alert(this.tList[0].reservationDate.localeCompare(new Date().toISOString().slice(0, 10)));
    if (this.up) {
      this.upList = this.tList.filter(t => t.reservationDate.localeCompare(new Date().toISOString().slice(0, 10)) >= 0);
      this.up = !this.up;
    }
    else {
      this.upList = [];
      this.up = !this.up;
    }
  }

  showPast() {
    if (this.past) {
      this.pastList = this.tList.filter(t => t.reservationDate.localeCompare(new Date().toISOString().slice(0, 10)) == -1);
      this.past = !this.past;
    }
    else {
      this.pastList = [];
      this.past = !this.past;
    }
  }

  upDelete(ticketId: number) {
    var ans = confirm("Are you sure to delete?");
    if (ans) {
      this.service.deleteTicket(ticketId);
      this.upList = this.upList.filter(upList => upList.ticketId != ticketId);
    }
  }

  pastDelete(ticketId: number) {
    var ans = confirm("Are you sure to delete?");
    if (ans) {
      this.service.deleteTicket(ticketId);
      this.pastList = this.pastList.filter(pastList => pastList.ticketId != ticketId);
    }
  }

  openModal(template: TemplateRef<any>,ticketId: number) { 
    this.service.tid = ticketId;
    this.modalRef = this.modalService.show(template);
    modalClass: 'modal-xl';
  }

  closeModal() {
    this.modalRef.hide();
  }


}
