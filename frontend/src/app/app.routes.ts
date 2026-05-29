import { Routes } from '@angular/router';
import { Login } from './pages/login/login';
import { Dashboard } from './pages/dashboard/dashboard';
import { Pacientes } from './pages/pacientes/pacientes';
import { authGuard } from './guards/auth-guard';
import { PacienteDetalhes } from './pages/paciente-detalhes/paciente-detalhes';
import { CriarConta } from './pages/criar-conta/criar-conta';

export const routes: Routes = [
  {
    path: '',
    component: Login,

  },
  {
    path: 'criarConta',
    component: CriarConta
  },
  {
    path: 'dashboard',
    component: Dashboard,
    canActivate: [authGuard]

  },
  {
    path: 'pacientes',
    component: Pacientes,
    canActivate : [authGuard]
  },
  {
    path: 'pacientes/:id',
    component:PacienteDetalhes,
    canActivate:[authGuard]
  }
];
