import { Component } from '@angular/core';
import { ClientAsideDashboard } from "../../components/client-aside-dashboard/client-aside-dashboard";
import { MissionResponse } from '../../interfaces/MissionResponse';
import { MissionService } from '../../services/mission.service';

@Component({
  selector: 'app-client-dashboard',
  imports: [ClientAsideDashboard],
  templateUrl: './client-dashboard.html',
  styleUrl: './client-dashboard.css',
})
export class ClientDashboard {
  missions: MissionResponse[] = [];

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
        console.log("data : " + data);
      },
       error: (err) => {
        console.error(err);
      }
    })
  }
}
