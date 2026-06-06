import { Component } from '@angular/core';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { CriarContaService } from '../../services/criar-conta-service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-criar-conta',
  imports: [ReactiveFormsModule, FormsModule],
  templateUrl: './criar-conta.html',
  styleUrl: './criar-conta.css',
})
export class CriarConta {

  formulario = new FormGroup({
    nome: new FormControl('',{nonNullable:true, validators:[Validators.required]}),
    email: new FormControl('',{nonNullable:true, validators:[Validators.required, Validators.email]}),
    password: new FormControl('',{nonNullable:true, validators:[Validators.required]}),
  })

  constructor(private readonly criarContaService: CriarContaService, private readonly router: Router){}


  criar(){
    const dados = this.formulario.getRawValue();

    if(this.formulario.invalid){
      alert("seu formulario esta inválido")
       return;
    }

    this.criarContaService.criarMedico(dados).subscribe({
      next:()=>{
        alert("Médico criado com sucesso")
        this.router.navigate([''])

      },
      error:(err)=>{
        alert("erro ao criar")
        console.log(err)
        alert(JSON.stringify(err))
      }
    })






  }

}
