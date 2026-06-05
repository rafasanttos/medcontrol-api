import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class Observacao {
  private api = 'https://medcontrol-api-up93.onrender.com/pacientes';

  constructor(private readonly http: HttpClient){}

  listarPorPaciente(pacienteId:string){
    return this.http.get(`${this.api}/${pacienteId}/observacoes`);
  }

  criar(pacienteId: string, data: any){
    return this.http.post(`${this.api}/${pacienteId}/observacoes`,data);
  }


}
