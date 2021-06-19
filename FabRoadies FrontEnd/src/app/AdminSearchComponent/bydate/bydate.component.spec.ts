import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BydateComponent } from './bydate.component';

describe('BydateComponent', () => {
  let component: BydateComponent;
  let fixture: ComponentFixture<BydateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BydateComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BydateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
