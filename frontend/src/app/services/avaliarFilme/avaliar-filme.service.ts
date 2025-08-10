import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../../environment/environment';
import { BuscarVotosService } from '../buscarVotos/buscar-votos.service';

@Injectable({
  providedIn: 'root'
})
export class AvaliarFilmeService {

  constructor(private httpClient: HttpClient) { }

  votarGostei(filmeId:number, tipoVoto:string):Observable<string>{
    return this.httpClient.post<string>(`${environment.apiUrl}/filmes/votos/positivos/${filmeId}`, {})
  }

  votarNaoGostei(filmeId:number, tipoVoto:string):Observable<string>{
    return this.httpClient.post<string>(`${environment.apiUrl}/filmes/votos/negativos/${filmeId}`, {})
  }
}
