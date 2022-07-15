import { TestBed } from '@angular/core/testing';

import { EquipmentOrgService } from './equipment-org.service';

describe('EquipmentOrgService', () => {
  let service: EquipmentOrgService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EquipmentOrgService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
