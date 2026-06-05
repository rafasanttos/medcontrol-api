import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class Auth {
  private api = 'https://medcontrol-api-up93.onrender.com/auth';

  constructor(private http: HttpClient){}

  login(data:any){
    return  this.http.post(`${this.api}/login`, data);
  }
}
