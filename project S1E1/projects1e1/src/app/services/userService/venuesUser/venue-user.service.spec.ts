import { TestBed } from '@angular/core/testing';

import { VenueUserService } from './venue-user.service';

describe('VenueUserService', () => {
  let service: VenueUserService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(VenueUserService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
