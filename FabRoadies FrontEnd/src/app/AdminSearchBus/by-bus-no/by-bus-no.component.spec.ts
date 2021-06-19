import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ByBusNoComponent } from './by-bus-no.component';

describe('ByBusNoComponent', () => {
  let component: ByBusNoComponent;
  let fixture: ComponentFixture<ByBusNoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ByBusNoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ByBusNoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
