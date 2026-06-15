import { isPlatformBrowser } from '@angular/common';
import { inject, PLATFORM_ID } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';

export const authGuard: CanActivateFn = () => {

  const router =inject(Router)
  const platFormId = inject(PLATFORM_ID);

  if(!isPlatformBrowser(platFormId)){
    return true;
  }


  const token = localStorage.getItem('token');

  if(token){
    return true;
  }


  router.navigate(['/login'])

  return false;

};
