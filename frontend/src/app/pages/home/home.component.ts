import { Component } from '@angular/core';
import { HeaderComponent } from "../../components/header/header.component";
import { CardMovieComponent } from "../../components/card-movie/card-movie.component";
import { VoteStatsComponent } from "../../components/vote-stats/vote-stats.component";
import { CadastrarFilmeComponent } from "../../components/cadastrar-filme/cadastrar-filme.component";
import { FooterComponent } from "../../components/footer/footer.component";

@Component({
  selector: 'app-home',
  imports: [HeaderComponent, CardMovieComponent, VoteStatsComponent, CadastrarFilmeComponent, FooterComponent],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent {

}
