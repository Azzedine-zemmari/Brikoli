import {HttpClient} from '@angular/common/http';
import { Observable } from "rxjs";
import { AuthResponse } from "../interfaces/AuthResponse";
import { environment } from '../environment';
import { Injectable } from '@angular/core';
import { RegisterDto } from '../interfaces/RegisterDto';



@Injectable({
    providedIn: 'root'
})

export class AuthService{
    constructor(private http:HttpClient){}


    login(loginData:any):Observable<AuthResponse>{
        return this.http.post<AuthResponse>(`${environment.apiUrl}/api/user/login`,loginData)
    }

    register(registerData:RegisterDto){
        return this.http.post<any>(`${environment.apiUrl}/api/user/register`,registerData)
    }
    
}