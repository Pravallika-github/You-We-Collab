import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FoodUserComponent } from './food-user.component';

describe('FoodUserComponent', () => {
  let component: FoodUserComponent;
  let fixture: ComponentFixture<FoodUserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FoodUserComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FoodUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
