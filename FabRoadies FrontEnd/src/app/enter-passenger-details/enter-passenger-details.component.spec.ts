import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EnterPassengerDetailsComponent } from './enter-passenger-details.component';

describe('EnterPassengerDetailsComponent', () => {
  let component: EnterPassengerDetailsComponent;
  let fixture: ComponentFixture<EnterPassengerDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EnterPassengerDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EnterPassengerDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
