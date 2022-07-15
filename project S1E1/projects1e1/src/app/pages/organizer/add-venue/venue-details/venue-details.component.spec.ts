import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VenueDetailsComponent } from './venue-details.component';

describe('VenueDetailsComponent', () => {
  let component: VenueDetailsComponent;
  let fixture: ComponentFixture<VenueDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VenueDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VenueDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
