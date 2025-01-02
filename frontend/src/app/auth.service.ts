// auth.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface ProfileAddInfoDto {
  name: string;
  bio: string;
  image: string;
  birthday: string;
  gender: string;
  phone: string;
  organization: string;
  location: string;
  website: string;
  social1: string;
  social2: string;
  social3: string;
  social4: string;
}

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

  updateProfile(profileData: ProfileAddInfoDto): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/profile/update`, profileData);
  }
}
