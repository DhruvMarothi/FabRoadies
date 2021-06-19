import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BysourceComponent } from './bysource.component';

describe('BysourceComponent', () => {
  let component: BysourceComponent;
  let fixture: ComponentFixture<BysourceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BysourceComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BysourceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
