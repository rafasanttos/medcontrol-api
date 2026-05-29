import { TestBed } from '@angular/core/testing';

import { Observacao } from './observacao';

describe('Observacao', () => {
  let service: Observacao;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Observacao);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
