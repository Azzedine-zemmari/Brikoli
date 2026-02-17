import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs";
import { MissionResponse } from "../interfaces/MissionResponse";
import { environment } from "../environment";
import { Injectable } from "@angular/core";

@Injectable({
    providedIn: 'root'
})


export class MissionService{
    constructor(private http:HttpClient){}

    // todo : switch this with interceptors
    private getAuthHeaders():HttpHeaders{
        const token = localStorage.getItem("token");
        return new HttpHeaders({
            'Authorization':`Bearer ${token}`
        })
    }

    showAll():Observable<MissionResponse[]>{
        return this.http.get<MissionResponse[]>(`${environment.apiUrl}/api/mission/user`,{
            headers: this.getAuthHeaders()
        })
    }
}