import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Pacienteservices } from '../../services/pacienteservices';
import { Observacao } from '../../services/observacao';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-paciente-detalhes',
  imports: [FormsModule, CommonModule],
  templateUrl: './paciente-detalhes.html',
  styleUrl: './paciente-detalhes.css',
})
export class PacienteDetalhes implements OnInit {
  paciente: any;
  observacoes: any[] = [];
  descricao:string = '';


  constructor(
    private route : ActivatedRoute,
    private pacienteService: Pacienteservices,
    private observacaoService:Observacao,
    private cd: ChangeDetectorRef
  ){}

  ngOnInit():void{
    const id = this.route.snapshot.paramMap.get('id');

    if(id){
      this.carregarPaciente(id);
      this.carregarObservacoes(id);
    }


  }
  carregarPaciente(id: string) {
  this.pacienteService.buscarPorId(id).subscribe({
    next: (res: any) => {
      this.paciente = res;
      this.cd.detectChanges()
    },
    error: (err) => {
      console.log(err);
    }
  });
}

  carregarObservacoes(id:string){
    this.observacaoService.listarPorPaciente(id).subscribe({
      next:(res:any)=>{
        this.observacoes = res;
        this.cd.detectChanges();
      },
      error:(err)=>console.log(err)
    })
  }

  criarObservacao(){
    const id = this.route.snapshot.paramMap.get('id');

    if(!id) return;

    const data = {
      descricao: this.descricao
    };

    this.observacaoService.criar(id,data).subscribe({
      next:()=>{
        this.descricao = '';
        this.carregarObservacoes(id);
        this.cd.detectChanges();
      },
        error: (err) => console.log(err)
    })
  }

}
