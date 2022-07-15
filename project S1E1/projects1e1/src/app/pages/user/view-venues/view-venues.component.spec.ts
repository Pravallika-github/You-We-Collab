import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewVenuesComponent } from './view-venues.component';

describe('ViewVenuesComponent', () => {
  let component: ViewVenuesComponent;
  let fixture: ComponentFixture<ViewVenuesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewVenuesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewVenuesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
