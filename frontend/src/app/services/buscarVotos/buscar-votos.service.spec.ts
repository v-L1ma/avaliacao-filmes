import { TestBed } from '@angular/core/testing';

import { BuscarVotosService } from './buscar-votos.service';

describe('BuscarVotosService', () => {
  let service: BuscarVotosService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BuscarVotosService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
