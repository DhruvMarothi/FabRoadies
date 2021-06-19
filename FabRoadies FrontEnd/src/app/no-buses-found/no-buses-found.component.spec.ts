import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NoBusesFoundComponent } from './no-buses-found.component';

describe('NoBusesFoundComponent', () => {
  let component: NoBusesFoundComponent;
  let fixture: ComponentFixture<NoBusesFoundComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NoBusesFoundComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NoBusesFoundComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
