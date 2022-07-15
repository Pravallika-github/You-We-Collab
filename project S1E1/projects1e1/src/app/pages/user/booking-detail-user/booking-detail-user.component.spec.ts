import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BookingDetailUserComponent } from './booking-detail-user.component';

describe('BookingDetailUserComponent', () => {
  let component: BookingDetailUserComponent;
  let fixture: ComponentFixture<BookingDetailUserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BookingDetailUserComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BookingDetailUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
