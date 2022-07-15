import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EquipmentsUserComponent } from './equipments-user.component';

describe('EquipmentsUserComponent', () => {
  let component: EquipmentsUserComponent;
  let fixture: ComponentFixture<EquipmentsUserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EquipmentsUserComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EquipmentsUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
