import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

interface Medico {
  nome: string,
  email:string,
  password:string
}

@Injectable({
  providedIn: 'root',
})
export class CriarContaService {

  constructor(private readonly http: HttpClient){}

  private api = 'http://localhost:8080';


  criarMedico(medico: Medico){
    return this.http.post<void>(`${this.api}/medicos`,medico)
  }
}
