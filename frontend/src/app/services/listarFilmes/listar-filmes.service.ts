import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ListarFilmesResponse } from '../../types/ListarFilmesResponse';
import { environment } from '../../../environment/environment';

@Injectable({
  providedIn: 'root'
})
export class ListarFilmesService {

  constructor(private httpClient:HttpClient) { }

  executar():Observable<ListarFilmesResponse>{
    return this.httpClient.get<ListarFilmesResponse>(`${environment.apiUrl}/filmes`)
  }
}
