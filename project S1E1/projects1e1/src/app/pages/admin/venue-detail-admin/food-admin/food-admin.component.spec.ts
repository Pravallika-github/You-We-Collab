import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FoodAdminComponent } from './food-admin.component';

describe('FoodAdminComponent', () => {
  let component: FoodAdminComponent;
  let fixture: ComponentFixture<FoodAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FoodAdminComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FoodAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
