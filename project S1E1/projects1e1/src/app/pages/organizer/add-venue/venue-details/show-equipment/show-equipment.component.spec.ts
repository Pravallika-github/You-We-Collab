import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowEquipmentComponent } from './show-equipment.component';

describe('ShowEquipmentComponent', () => {
  let component: ShowEquipmentComponent;
  let fixture: ComponentFixture<ShowEquipmentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShowEquipmentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowEquipmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
