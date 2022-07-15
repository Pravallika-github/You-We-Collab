import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewBookingsAdminComponent } from './view-bookings-admin.component';

describe('ViewBookingsAdminComponent', () => {
  let component: ViewBookingsAdminComponent;
  let fixture: ComponentFixture<ViewBookingsAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewBookingsAdminComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewBookingsAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
