import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { CategoryResponse } from "../interfaces/CategoryResponse";
import { environment } from "../environment";

@Injectable({
    providedIn: 'root'
})

export class CategoryService{
    constructor(private http:HttpClient){}

    private getAuthHeaders():HttpHeaders{
        const token = localStorage.getItem("token");
        console.log('Token from localStorage:', token);
        return new HttpHeaders({
            'Authorization':`Bearer ${token}`
        })
    }
    getCategories():Observable<CategoryResponse[]>{
        return this.http.get<CategoryResponse[]>(`${environment.apiUrl}/api/category/all`,{headers:this.getAuthHeaders()})
    }
}