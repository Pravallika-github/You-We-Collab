import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateEquipmentComponent } from './update-equipment.component';

describe('UpdateEquipmentComponent', () => {
  let component: UpdateEquipmentComponent;
  let fixture: ComponentFixture<UpdateEquipmentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateEquipmentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateEquipmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
