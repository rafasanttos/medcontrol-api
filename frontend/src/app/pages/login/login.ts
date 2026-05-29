import { Component } from '@angular/core';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { Auth } from '../../services/auth';
import e, { response } from 'express';
import { error } from 'console';
import { Router } from '@angular/router';
import { email } from '@angular/forms/signals';
import { CommonModule } from '@angular/common';



@Component({
  selector: 'app-login',
  imports: [FormsModule, ReactiveFormsModule,CommonModule],
  templateUrl: './login.html',
  styleUrl: './login.css',
})




export class Login {

  formularioLogin= new FormGroup({
    email: new FormControl('',{nonNullable:true, validators:[Validators.required,Validators.email]}),
    password: new FormControl('',{nonNullable:true, validators:[Validators.required]})
  })




  constructor(private authService: Auth,
    private router: Router
  ){}



  login(){
    console.log("clicou no login")
    console.log(this.formularioLogin.value);
    console.log(this.formularioLogin.valid);

    if (this.formularioLogin.invalid) {
      this.formularioLogin.markAllAsTouched();
      return;
    }
    const dados = this.formularioLogin.getRawValue();
    console.log(dados)



    this.authService.login(dados).subscribe({
      next: (response: any)=>{
      localStorage.setItem('token',response.token);
      console.log("token salvo")
      this.router.navigate(['/pacientes'])
      },
      error:(err)=>{
        console.log(err)
        this.router.navigate([''])
      }
    })
  }



}
