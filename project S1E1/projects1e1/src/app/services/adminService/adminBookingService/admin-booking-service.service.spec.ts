import { TestBed } from '@angular/core/testing';

import { AdminBookingServiceService } from './admin-booking-service.service';

describe('AdminBookingServiceService', () => {
  let service: AdminBookingServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AdminBookingServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
