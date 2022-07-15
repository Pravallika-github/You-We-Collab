import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VenueDetailUserComponent } from './venue-detail-user.component';

describe('VenueDetailUserComponent', () => {
  let component: VenueDetailUserComponent;
  let fixture: ComponentFixture<VenueDetailUserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VenueDetailUserComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VenueDetailUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
