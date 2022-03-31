import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService
{
  constructor(private http: HttpClient) { }

  public loginx(params: any): Observable<any>
  {
    return this.http.post("localhot:8080/api/user/login",params);
  }
}
