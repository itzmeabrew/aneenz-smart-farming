import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChartPsrComponent } from './chart-psr.component';

describe('ChartPsrComponent', () => {
  let component: ChartPsrComponent;
  let fixture: ComponentFixture<ChartPsrComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ChartPsrComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ChartPsrComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
