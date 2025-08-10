import { Component, Input, } from '@angular/core';

@Component({
  selector: 'app-card-movie',
  imports: [],
  templateUrl: './card-movie.component.html',
  styleUrl: './card-movie.component.scss'
})
export class CardMovieComponent {
  @Input({required:true}) titulo!:string ;
  @Input({required:true}) genero!: string;
  @Input({required:true}) descricao!: string;
  @Input({required:true}) imagem!: string;
  @Input({required:true}) gostei!: number;
  @Input({required:true}) naoGostei!: number;

  votarGostei(){
    this.gostei += 1 
  }

  votarNaoGostei(){
    this.naoGostei += 1 
  }
}
