import { Component, OnInit } from '@angular/core';
import { ProfessionalHeader } from "../../components/professional-header/professional-header";
import { SidebarFilter } from '../../components/sidebar-filter/sidebar-filter';
import { MissionResponse } from '../../interfaces/MissionResponse';
import { MissionService } from '../../services/mission.service';

@Component({
  selector: 'app-missions',
  imports: [ProfessionalHeader,SidebarFilter],
  templateUrl: './missions.html',
  styleUrl: './missions.css', 
})
export class Missions implements OnInit{
    mission : MissionResponse[] = [];

    constructor(private missionService:MissionService){}

    ngOnInit():void{
      this.fetchMissions();
    }

    fetchMissions(){
      this.missionService.showMissions().subscribe({
        next:(data) => {
          this.mission = data;
          console.log(this.mission)
        },
        error:(err) => {
          console.log(err)
        }
      })
    }
}
