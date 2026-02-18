import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfessionalHeader } from './professional-header';

describe('ProfessionalHeader', () => {
  let component: ProfessionalHeader;
  let fixture: ComponentFixture<ProfessionalHeader>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ProfessionalHeader]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProfessionalHeader);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
