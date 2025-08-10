import { Component } from '@angular/core';
import { HeaderComponent } from "../../components/header/header.component";
import { CardMovieComponent } from "../../components/card-movie/card-movie.component";
import { VoteStatsComponent } from "../../components/vote-stats/vote-stats.component";
import { CadastrarFilmeComponent } from "../../components/cadastrar-filme/cadastrar-filme.component";
import { FooterComponent } from "../../components/footer/footer.component";
import { Filme } from '../../types/Filme';
import { ListarFilmesService } from '../../services/listarFilmes/listar-filmes.service';

@Component({
  selector: 'app-home',
  imports: [HeaderComponent, CardMovieComponent, VoteStatsComponent, CadastrarFilmeComponent, FooterComponent],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent {

  filmes: Filme[] = [];

  constructor(private ListarFilmesService: ListarFilmesService){
    this.ListarFilmesService.executar().subscribe({
      next:(response)=>{
        console.log(response)
        this.filmes=response.filmes;
      },
      error:(error)=>{
        console.log(error)
      }
    })
  }

}
