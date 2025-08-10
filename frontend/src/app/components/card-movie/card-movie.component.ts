import { Component, Input, } from '@angular/core';
import { AvaliarFilmeService } from '../../services/avaliarFilme/avaliar-filme.service';
import { ListarFilmesService } from '../../services/listarFilmes/listar-filmes.service';
import { BuscarVotosService } from '../../services/buscarVotos/buscar-votos.service';

@Component({
  selector: 'app-card-movie',
  imports: [],
  templateUrl: './card-movie.component.html',
  styleUrl: './card-movie.component.scss'
})
export class CardMovieComponent {
  @Input({required:true}) id!:number ;
  @Input({required:true}) titulo!:string ;
  @Input({required:true}) genero!: string;
  @Input({required:true}) descricao!: string;
  @Input({required:true}) imagem!: string;
  @Input({required:true}) gostei!: number;
  @Input({required:true}) naoGostei!: number;

  constructor(private avaliarFilmeService:AvaliarFilmeService, private listarFilmesService:ListarFilmesService, private buscarVotosService: BuscarVotosService){}

  votarGostei(id:number){
    this.gostei+=1;
    this.buscarVotosService.votarGostei()
    this.avaliarFilmeService.votarGostei(id,"gostei").subscribe({
      next:(response)=>{
        console.log(response)
      },
      error:(error)=>{
        console.log(error)
      }
    })
  }

  votarNaoGostei(id:number){
    this.naoGostei+=1;
    this.buscarVotosService.votarNaoGostei()
    this.avaliarFilmeService.votarNaoGostei(id,"naoGostei").subscribe({
      next:(response)=>{
        console.log(response)
      },
      error:(error)=>{
        console.log(error)
      }
    })
  }
}
