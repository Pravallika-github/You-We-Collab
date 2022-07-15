import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BookDetailPastComponent } from './book-detail-past.component';

describe('BookDetailPastComponent', () => {
  let component: BookDetailPastComponent;
  let fixture: ComponentFixture<BookDetailPastComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BookDetailPastComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BookDetailPastComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
