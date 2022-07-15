import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewVenuesAdminComponent } from './view-venues-admin.component';

describe('ViewVenuesAdminComponent', () => {
  let component: ViewVenuesAdminComponent;
  let fixture: ComponentFixture<ViewVenuesAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewVenuesAdminComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewVenuesAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
