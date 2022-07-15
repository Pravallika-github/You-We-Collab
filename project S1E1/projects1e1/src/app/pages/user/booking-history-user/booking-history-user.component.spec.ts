import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BookingHistoryUserComponent } from './booking-history-user.component';

describe('BookingHistoryUserComponent', () => {
  let component: BookingHistoryUserComponent;
  let fixture: ComponentFixture<BookingHistoryUserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BookingHistoryUserComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BookingHistoryUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
