import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FutureBookingComponent } from './future-booking.component';

describe('FutureBookingComponent', () => {
  let component: FutureBookingComponent;
  let fixture: ComponentFixture<FutureBookingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FutureBookingComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FutureBookingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
