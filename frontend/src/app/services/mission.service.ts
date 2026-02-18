import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs";
import { MissionResponse } from "../interfaces/MissionResponse";
import { environment } from "../environment";
import { Injectable } from "@angular/core";
import { MissionRequest } from "../interfaces/MissionRequest";

@Injectable({
    providedIn: 'root'
})


export class MissionService{
    constructor(private http:HttpClient){}

    // todo : switch this with interceptors
    private getAuthHeaders():HttpHeaders{
        const token = localStorage.getItem("token");
        console.log('Token from localStorage:', token);
        return new HttpHeaders({
            'Authorization':`Bearer ${token}`
        })
    }
    // show all for user
    showAll():Observable<MissionResponse[]>{
        return this.http.get<MissionResponse[]>(`${environment.apiUrl}/api/mission/user`,{
            headers: this.getAuthHeaders()
        })
    }
    createMission(mission: MissionRequest): Observable<MissionRequest> {
        const token = localStorage.getItem("token");
        return this.http.post<MissionRequest>(
            `${environment.apiUrl}/api/mission/create`,
            mission,
            {
                headers: {
                    'Authorization': `Bearer ${token}`,
                    'Content-Type': 'application/json'
                }
            }
        );
    }

    countPosted():Observable<number>{
        return this.http.get<number>(`${environment.apiUrl}/api/mission/posted`,{
            headers: this.getAuthHeaders()
        })
    }
    countEncours():Observable<number>{
        return this.http.get<number>(`${environment.apiUrl}/api/mission/en_cours`,{
            headers: this.getAuthHeaders()
        })
    }
    countCompleted():Observable<number>{
        return this.http.get<number>(`${environment.apiUrl}/api/mission/completed`,{
            headers: this.getAuthHeaders()
        })
    }
    // for professional or admin
    showMissions():Observable<MissionResponse[]>{
        return this.http.get<MissionResponse[]>(`${environment.apiUrl}/api/mission/all`,{
            headers: this.getAuthHeaders()
        })
    }
}