import { Component, OnInit } from '@angular/core';
import { BuscarVotosService } from '../../services/buscarVotos/buscar-votos.service';

@Component({
  selector: 'app-vote-stats',
  imports: [],
  templateUrl: './vote-stats.component.html',
  styleUrl: './vote-stats.component.scss'
})
export class VoteStatsComponent implements OnInit{

  gostei:number=0;
  naoGostei:number=0;
  total:number=0;

  constructor(private buscarVotosService: BuscarVotosService){}

  ngOnInit() {
    this.buscarVotosService.votos$.subscribe(votos => {
      this.gostei = votos.gostei;
      this.naoGostei = votos.naoGostei;
      this.total = votos.total;
    });
  }

}
