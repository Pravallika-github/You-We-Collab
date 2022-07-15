import { TestBed } from '@angular/core/testing';

import { FoodOrgService } from './food-org.service';

describe('FoodOrgService', () => {
  let service: FoodOrgService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FoodOrgService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
