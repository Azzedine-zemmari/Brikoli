import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { ProfessionalHeader } from "../../components/professional-header/professional-header";
import { SidebarFilter } from '../../components/sidebar-filter/sidebar-filter';
import { MissionResponse } from '../../interfaces/MissionResponse';
import { MissionService } from '../../services/mission.service';

@Component({
  selector: 'app-missions',
  imports: [ProfessionalHeader, SidebarFilter],
  templateUrl: './missions.html',
  styleUrl: './missions.css',
})
export class Missions implements OnInit {
  mission: MissionResponse[] = [];

  constructor(private missionService: MissionService, private cdr: ChangeDetectorRef) { }

  ngOnInit(): void {
    this.fetchMissions();
  }

  fetchMissions() {
    this.missionService.showMissions().subscribe({
      next: (data) => {
        this.mission = data;
        this.cdr.detectChanges();
        console.log(this.mission)
      },
      error: (err) => {
        console.log(err)
      }
    })
  }
  getTimeAgo(dateString: string): string {
    const now = new Date();
    const created = new Date(dateString);

    const diffMs = now.getTime() - created.getTime();
    const diffMinutes = Math.floor(diffMs / (1000 * 60));
    const diffHours = Math.floor(diffMinutes / 60);
    const diffDays = Math.floor(diffHours / 24);

    if (diffMinutes < 60) {
      return `${diffMinutes} min ago`;
    } else if (diffHours < 24) {
      return `${diffHours} h ago`;
    } else {
      return `${diffDays} day(s) ago`;
    }
  }

}
