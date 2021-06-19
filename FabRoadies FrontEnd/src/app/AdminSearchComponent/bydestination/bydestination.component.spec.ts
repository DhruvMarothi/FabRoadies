import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BydestinationComponent } from './bydestination.component';

describe('BydestinationComponent', () => {
  let component: BydestinationComponent;
  let fixture: ComponentFixture<BydestinationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BydestinationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BydestinationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
