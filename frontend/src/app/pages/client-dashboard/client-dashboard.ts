import { Component, OnInit } from '@angular/core';
import { ClientAsideDashboard } from "../../components/client-aside-dashboard/client-aside-dashboard";
import { MissionResponse } from '../../interfaces/MissionResponse';
import { MissionService } from '../../services/mission.service';
import { CommonModule, DatePipe } from '@angular/common';
@Component({
  selector: 'app-client-dashboard',
  imports: [ClientAsideDashboard,CommonModule],
  templateUrl: './client-dashboard.html',
  styleUrl: './client-dashboard.css',
})
export class ClientDashboard  implements OnInit{
  public missions: MissionResponse[] = [];

  constructor(private missionService:MissionService){}

  ngOnInit():void{
    this.fetchMissions();
  }

  fetchMissions():void{
    this.missionService.showAll().subscribe({
      next:(data)=>{
        // BECAUSE THE DATA IS COMMING FROM THE BACKEND AS ARRAY 
        // THAT WHY I ASSIGN IT DIRECTLY WITHOUT PUSH *
        this.missions = data;
        console.log("missions : " , this.missions);
        console.log("data : " , data);
      },
        error: (err) => {
        console.error(err);
      }
    })
  }
  trackById(index: number, mission: MissionResponse) {
    return mission.id;
  }
}
