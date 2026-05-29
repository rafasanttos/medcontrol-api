import { TestBed } from '@angular/core/testing';

import { Pacienteservices } from './pacienteservices';

describe('Pacienteservices', () => {
  let service: Pacienteservices;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Pacienteservices);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
