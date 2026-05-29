import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';

export const authGuard: CanActivateFn = () => {

  const router =inject(Router)

  if(typeof window !== 'undefined'){
    const token = localStorage.getItem('token');
    return !!token;
  }

  router.navigate(['/src/app/pages/login'])

  return false;

};
