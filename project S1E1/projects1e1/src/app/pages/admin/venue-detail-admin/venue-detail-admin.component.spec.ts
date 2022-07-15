import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VenueDetailAdminComponent } from './venue-detail-admin.component';

describe('VenueDetailAdminComponent', () => {
  let component: VenueDetailAdminComponent;
  let fixture: ComponentFixture<VenueDetailAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VenueDetailAdminComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VenueDetailAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
