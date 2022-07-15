import { TestBed } from '@angular/core/testing';

import { EventOrgService } from './event-org.service';

describe('EventOrgService', () => {
  let service: EventOrgService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EventOrgService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
