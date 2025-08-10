import { TestBed } from '@angular/core/testing';

import { AvaliarFilmeService } from './avaliar-filme.service';

describe('AvaliarFilmeService', () => {
  let service: AvaliarFilmeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AvaliarFilmeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
