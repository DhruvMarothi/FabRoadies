import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TicketBookingPageComponent } from './ticket-booking-page.component';

describe('TicketBookingPageComponent', () => {
  let component: TicketBookingPageComponent;
  let fixture: ComponentFixture<TicketBookingPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TicketBookingPageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TicketBookingPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
