import { Component, OnInit, OnDestroy, TemplateRef } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BsModalService } from 'ngx-bootstrap/modal';
import { BsModalRef } from 'ngx-bootstrap/modal/bs-modal-ref.service';
import { bus } from 'src/app/ticket-booking-page/bus.model'
import { BusAdmin } from 'src/BusAdmin.model';
import { AdminService } from '../services/admin.service';
import { filter } from 'rxjs/operators';



@Component({
  selector: 'app-ticket-booking-page',
  templateUrl: './ticket-booking-page.component.html',
  styleUrls: ['./ticket-booking-page.component.css']
})
export class TicketBookingPageComponent implements OnInit, OnDestroy {
  modalRef!: BsModalRef;
  bus!: BusAdmin;
  //Routing to be done 
  buses: BusAdmin[] = [];// bus array to be populated from browse page results ; if 0 to be routed to no-buses-found page
  constructor(
    private modalService: BsModalService, private service: AdminService, private router: Router, private aroute: ActivatedRoute) { }
  ngOnDestroy(): void {
    throw new Error("Method not implemented.");
  }

  ngOnInit(): void {

    this.aroute.queryParams.pipe(filter(params => (params.src, params.dest, params.date))).subscribe(params => {

      this.service.findbus(params.src, params.dest, params.date).subscribe(data => this.buses = data);
    })
  }

  saveBus(bus: BusAdmin) {
    this.bus = bus;
  }

  openModal(template: TemplateRef<any>) {
    this.service.busObj = this.bus;
    var t = localStorage.getItem('user');

    // if (localStorage.getItem('user') == null) {
    //   this.router.navigate(['login']);
    // }

    this.modalRef = this.modalService.show(template);
    modalClass: 'modal-xl';
  }

  closeModal() {
    this.modalRef.hide();
  }

}

