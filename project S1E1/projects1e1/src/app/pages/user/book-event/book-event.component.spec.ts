import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BookEventComponent } from './book-event.component';

describe('BookEventComponent', () => {
  let component: BookEventComponent;
  let fixture: ComponentFixture<BookEventComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BookEventComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BookEventComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
