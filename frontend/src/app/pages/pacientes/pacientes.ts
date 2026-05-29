import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { Pacienteservices } from '../../services/pacienteservices';
import { CommonModule } from '@angular/common';
import { Route, Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

interface TipoPaciente {
  id:string,
  nome:string,
  nomeMedico:string
}

@Component({
  selector: 'app-pacientes',
  standalone : true,
  imports: [CommonModule, FormsModule],
  templateUrl: './pacientes.html',
  styleUrl: './pacientes.css',
})


export class Pacientes implements OnInit {

  editandoId: string | null = null;
  nomeEditado: string = '';

  nomePaciente:string = '';

  pacientes: TipoPaciente[] = [];


  constructor(private readonly  pacienteService:Pacienteservices , private cd : ChangeDetectorRef, private router:Router){}

    ngOnInit(): void{
      this.listarPacientes()
    }

  verPaciente(id:string){
    this.router.navigate(['/pacientes',id])
  }


  criarPaciente(){
    const data = {
      nome: this.nomePaciente
    };

    this.pacienteService.criarPaciente(data).subscribe({
      next:()=>{
        this.nomePaciente='';
        this.listarPacientes()
      },
      error:(err)=>{
        console.log(err)
      }
    })
  }


  logout(){
    localStorage.removeItem('token');
    this.router.navigate(['']);
  }

  listarPacientes(){
    this.pacienteService.listarMeusPacientes().subscribe({
      next:(valorRetornado : any)=>{

         this.pacientes = valorRetornado;
         this.cd.detectChanges();

      },
      error:(err)=>{
        console.log("erro api")
        console.log(err)
      }
    })
  }

  deletarPaciente(id:string){

    const  confirmado = confirm("Tem certeza que quer excluir?")
    if(!confirmado){
      return;
    }
    this.pacienteService.deletarPaciente(id).subscribe({

      next:()=>{
        this.pacientes = this.pacientes.filter(p=>p.id !== id)
        this.cd.detectChanges();

        alert("Excluido com sucesso")
      },
      error:(err)=>{
        console.log("ERRO COMPLETO:", err);
        console.log("STATUS:", err.status);
        console.log("MESSAGE:", err.message);


      }
    })
  }

  prepararEdicao(paciente: any) {
    this.editandoId = paciente.id;
    this.nomeEditado = paciente.nome;
  }

cancelarEdicao() {
  this.editandoId = null;
  this.nomeEditado = '';
}

salvarEdicao() {
  if (!this.editandoId) return;

  const data = {
    nome: this.nomeEditado
  };

  this.pacienteService.atualizarPaciente(this.editandoId, data).subscribe({
    next: (res: any) => {
      this.pacientes = this.pacientes.map(p =>
        p.id === this.editandoId ? res : p
      );

      this.editandoId = null;
      this.nomeEditado = '';
      this.cd.detectChanges();

      alert('Paciente atualizado com sucesso');
    },
    error: (err) => {
      console.log(err);
      alert('Erro ao atualizar paciente');
    }
  });
}


}
