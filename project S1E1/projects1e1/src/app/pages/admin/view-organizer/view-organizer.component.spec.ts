import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewOrganizerComponent } from './view-organizer.component';

describe('ViewOrganizerComponent', () => {
  let component: ViewOrganizerComponent;
  let fixture: ComponentFixture<ViewOrganizerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewOrganizerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewOrganizerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
