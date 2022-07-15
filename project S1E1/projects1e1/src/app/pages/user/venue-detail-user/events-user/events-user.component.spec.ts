import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EventsUserComponent } from './events-user.component';

describe('EventsUserComponent', () => {
  let component: EventsUserComponent;
  let fixture: ComponentFixture<EventsUserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EventsUserComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EventsUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
