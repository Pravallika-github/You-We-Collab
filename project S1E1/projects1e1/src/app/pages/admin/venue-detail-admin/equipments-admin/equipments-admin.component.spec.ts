import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EquipmentsAdminComponent } from './equipments-admin.component';

describe('EquipmentsAdminComponent', () => {
  let component: EquipmentsAdminComponent;
  let fixture: ComponentFixture<EquipmentsAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EquipmentsAdminComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EquipmentsAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
