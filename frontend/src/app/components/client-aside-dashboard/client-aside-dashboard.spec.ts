import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClientAsideDashboard } from './client-aside-dashboard';

describe('ClientAsideDashboard', () => {
  let component: ClientAsideDashboard;
  let fixture: ComponentFixture<ClientAsideDashboard>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ClientAsideDashboard]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ClientAsideDashboard);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
