import { Component } from '@angular/core';

@Component({
  selector: 'app-cadastrar-filme',
  imports: [],
  templateUrl: './cadastrar-filme.component.html',
  styleUrl: './cadastrar-filme.component.scss'
})
export class CadastrarFilmeComponent {
  isOpen:boolean = false;

  open(){
    this.isOpen = !this.isOpen;
  }
}
