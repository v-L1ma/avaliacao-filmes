import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Filme } from '../../types/Filme';
import { Observable } from 'rxjs';
import { CadastrarFilmeResponse } from '../../types/CadastrarFilmeResponse';
import { environment } from '../../../environment/environment';

@Injectable({
  providedIn: 'root'
})
export class CadastrarFilmeService {

  constructor(private httpClient:HttpClient) { }

  executar(filme:Filme):Observable<CadastrarFilmeResponse>{
    return this.httpClient.post<CadastrarFilmeResponse>(`${environment.apiUrl}/filmes`, filme)
  }
}
