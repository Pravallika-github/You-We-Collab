import { TestBed } from '@angular/core/testing';

import { VenueOrgService } from './venue-org.service';

describe('VenueOrgService', () => {
  let service: VenueOrgService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(VenueOrgService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
