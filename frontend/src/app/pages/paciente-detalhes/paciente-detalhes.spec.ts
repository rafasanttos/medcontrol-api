import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PacienteDetalhes } from './paciente-detalhes';

describe('PacienteDetalhes', () => {
  let component: PacienteDetalhes;
  let fixture: ComponentFixture<PacienteDetalhes>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PacienteDetalhes],
    }).compileComponents();

    fixture = TestBed.createComponent(PacienteDetalhes);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
