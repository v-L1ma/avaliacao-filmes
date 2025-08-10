import { Component, EventEmitter, Output } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { CadastrarFilmeService } from '../../services/cadastrarFilme/cadastrar-filme.service';

@Component({
  selector: 'app-cadastrar-filme',
  imports: [ReactiveFormsModule],
  templateUrl: './cadastrar-filme.component.html',
  styleUrl: './cadastrar-filme.component.scss'
})
export class CadastrarFilmeComponent {
  isOpen:boolean = false;
  cadastrarForm!: FormGroup;

  @Output() listarFilmes = new EventEmitter<void>();

  constructor(private cadastrarFilmeService:CadastrarFilmeService){
    this.cadastrarForm = new FormGroup({
      titulo: new FormControl("", [Validators.required, Validators.maxLength(50)]),
      genero: new FormControl("", [Validators.required, Validators.maxLength(25)]),
      imagem: new FormControl("", [Validators.required, Validators.maxLength(500)]),
      descricao: new FormControl("", [Validators.maxLength(100)])
    })
  }

  get getTitulo(){
    return this.cadastrarForm.get('titulo');
  }
  
  get getGenero(){
    return this.cadastrarForm.get('genero');
  }

  get getImagem(){
    return this.cadastrarForm.get('imagem');
  }

  get getDescricao(){
    return this.cadastrarForm.get('descricao');
  }

  open(){
    this.isOpen = !this.isOpen;
  }

  enviar(){
    if(!this.cadastrarForm.invalid){
      console.log(this.cadastrarForm.value)
      this.cadastrarFilmeService.executar(this.cadastrarForm.value).subscribe({
        next:(response)=>{
          console.log(response)
          this.listarFilmes.emit()
          this.open();
        },
        error:(error)=>{
          console.log(error)
        }
      })
    }
  }
}
