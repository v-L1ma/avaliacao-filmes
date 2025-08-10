import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { environment } from '../../../environment/environment';
import { BuscarVotosResponse } from '../../types/BuscarVotosResponse';

@Injectable({ providedIn: 'root' })
export class BuscarVotosService {

  private gostei = 0;
  private naoGostei = 0;
  private total = 0;

  private votosSubject = new BehaviorSubject<{ gostei: number; naoGostei: number; total: number }>({
    gostei: 0,
    naoGostei: 0,
    total: 0
  });

  votos$ = this.votosSubject.asObservable();

  constructor(private httpClient: HttpClient) {
    this.carregarVotos();
  }

  private carregarVotos() {
    this.httpClient.get<BuscarVotosResponse>(`${environment.apiUrl}/filmes/votos/negativos`)
      .subscribe({
        next: (response) => {
          this.naoGostei = response.votos;
          this.emitir();
        },
        error: (error) => { console.error(error); }
      });

    this.httpClient.get<BuscarVotosResponse>(`${environment.apiUrl}/filmes/votos/positivos`)
      .subscribe({
        next: (response) => {
          this.gostei = response.votos;
          this.emitir();
        },
        error: (error) => { console.error(error); }
      });

    this.httpClient.get<BuscarVotosResponse>(`${environment.apiUrl}/filmes/votos`)
      .subscribe({
        next: (response) => {
          this.total = response.votos;
          this.emitir();
        },
        error: (error) => { console.error(error); }
      });
  }

  private emitir() {
    this.votosSubject.next({
      gostei: this.gostei,
      naoGostei: this.naoGostei,
      total: this.total
    });
  }

  votarGostei() {
    this.gostei++;
    this.total++;
    this.emitir();
  }

  votarNaoGostei() {
    this.naoGostei++;
    this.total++;
    this.emitir();
  }
}
