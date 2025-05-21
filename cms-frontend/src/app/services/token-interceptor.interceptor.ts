import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor,
  HttpErrorResponse
} from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { Router } from '@angular/router';
import { catchError } from 'rxjs/operators'

@Injectable()
export class TokenInterceptorInterceptor implements HttpInterceptor {

  constructor(private router:Router) {}

  // original interceptor
  // intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
  //   const token = localStorage.getItem('token');
  //   if(token){
  //     request = request.clone({
  //       setHeaders: {Authorization: 'Bearer ${token}'}
  //     });
  //   }
  //   return next.handle(request).pipe(
  //     catchError((err)=>{
  //       if(err instanceof HttpErrorResponse){
  //         console.log(err.url);
  //         if(err.status === 401 || err.status === 403){
  //           if(this.router.url === '/'){}
  //           else{
  //             //localStorage.clear();
  //             this.router.navigate(['/']);
  //           }
  //         }
  //       }
  //       return throwError(err);
  //     })
  //   );
  // }

  //my interceptor
  intercept(req: HttpRequest<any>,
    next: HttpHandler): Observable<HttpEvent<any>> {

const token = localStorage.getItem("token");

if (token) {
  const cloned = req.clone({
      headers: req.headers.set("Authorization",
          "Bearer " + token)
  });

  return next.handle(cloned);
}
else {
  return next.handle(req);
}
}
}
