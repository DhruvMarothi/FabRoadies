import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminBrowseComponent } from './admin-browse.component';

describe('AdminBrowseComponent', () => {
  let component: AdminBrowseComponent;
  let fixture: ComponentFixture<AdminBrowseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminBrowseComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminBrowseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
