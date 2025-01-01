import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) {}

  signUp(username: string, email: string, password: string): Observable<any> {
    return this.http.post(`${this.apiUrl}/signup`, { username, email, password });
  }

  signIn(username: string, password: string): Observable<any> {
    return this.http.post(`${this.apiUrl}/signin`, { username, password });
  }
}