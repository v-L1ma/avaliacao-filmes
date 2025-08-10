import { TestBed } from '@angular/core/testing';

import { ListarFilmesService } from './listar-filmes.service';

describe('ListarFilmesService', () => {
  let service: ListarFilmesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ListarFilmesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
