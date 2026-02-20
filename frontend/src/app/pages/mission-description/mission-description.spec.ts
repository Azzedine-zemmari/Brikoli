import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MissionDescription } from './mission-description';

describe('MissionDescription', () => {
  let component: MissionDescription;
  let fixture: ComponentFixture<MissionDescription>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MissionDescription]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MissionDescription);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
