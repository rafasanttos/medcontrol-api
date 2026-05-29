import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class Pacienteservices {
  private api = 'http://localhost:8080/pacientes';

  constructor(private http : HttpClient){}

  listarMeusPacientes(){
    return this.http.get(`${this.api}/me`)
  }

  criarPaciente(data:any){
    return this.http.post(`${this.api}`,data)
  }

  buscarPorId(id:string){
    return this.http.get(`${this.api}/${id}`)
  }

  deletarPaciente(id:string){
    return this.http.delete<void>(`${this.api}/${id}`)
  }


  atualizarPaciente(id: string, data: any) {
    return this.http.put(`${this.api}/${id}`, data);
  }

}
