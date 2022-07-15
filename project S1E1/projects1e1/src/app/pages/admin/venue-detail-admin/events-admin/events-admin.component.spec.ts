import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EventsAdminComponent } from './events-admin.component';

describe('EventsAdminComponent', () => {
  let component: EventsAdminComponent;
  let fixture: ComponentFixture<EventsAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EventsAdminComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EventsAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
