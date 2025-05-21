import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  url = environment.apiUrl;

  constructor(private httpClient:HttpClient) { }

  // signup(data:any){
  //   return this.httpClient.post(this.url+
  //     "/user/signup",data,{
  //       headers:new HttpHeaders().set('Content-Type', 'application/json')
  //     })
  // }

  signup(data:any){
    return this.httpClient.post(
      "http://localhost:8081/user/signup",data,{
        headers:new HttpHeaders().set('Content-Type', 'application/json')
      })
  }

  login(data:any){
    return this.httpClient.post(
      "http://localhost:8081/user/login",data,{
        headers:new HttpHeaders().set('Content-Type', 'application/json')
      })
  }

  checkToken(){
    return this.httpClient.get("http://localhost:8081/user/checkToken");
  }

  changePassword(data:any){
    return this.httpClient.post(
      "http://localhost:8081/user/changePassword",data,{
        headers:new HttpHeaders().set('Content-Type', 'application/json')
      })
  }
}
