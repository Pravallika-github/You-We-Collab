import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowEventsComponent } from './show-events.component';

describe('ShowEventsComponent', () => {
  let component: ShowEventsComponent;
  let fixture: ComponentFixture<ShowEventsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShowEventsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowEventsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
