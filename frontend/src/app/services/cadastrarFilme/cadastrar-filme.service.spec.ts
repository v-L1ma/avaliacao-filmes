import { TestBed } from '@angular/core/testing';

import { CadastrarFilmeService } from './cadastrar-filme.service';

describe('CadastrarFilmeService', () => {
  let service: CadastrarFilmeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CadastrarFilmeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
