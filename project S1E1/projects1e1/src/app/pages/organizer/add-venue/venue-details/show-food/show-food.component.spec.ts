import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowFoodComponent } from './show-food.component';

describe('ShowFoodComponent', () => {
  let component: ShowFoodComponent;
  let fixture: ComponentFixture<ShowFoodComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShowFoodComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowFoodComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
