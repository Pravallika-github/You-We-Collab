import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrgNotificationsComponent } from './org-notifications.component';

describe('OrgNotificationsComponent', () => {
  let component: OrgNotificationsComponent;
  let fixture: ComponentFixture<OrgNotificationsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OrgNotificationsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OrgNotificationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
