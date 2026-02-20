import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { ProfessionalHeader } from "../../components/professional-header/professional-header";
import { SidebarFilter } from '../../components/sidebar-filter/sidebar-filter';
import { MissionResponse } from '../../interfaces/MissionResponse';
import { MissionService } from '../../services/mission.service';
import { RouterLink } from '@angular/router';
import { TimeService } from '../../services/time';

@Component({
  selector: 'app-missions',
  imports: [ProfessionalHeader, SidebarFilter,RouterLink],
  templateUrl: './missions.html',
  styleUrl: './missions.css',
})
export class Missions implements OnInit {
  allMissions: MissionResponse[] = []; // full data from API
  mission: MissionResponse[] = [];     // filtered data

  constructor(private missionService: MissionService, private cdr: ChangeDetectorRef ,public timeService:TimeService
  ) { }

  ngOnInit(): void {
    this.fetchMissions();
  }

  fetchMissions() {
    this.missionService.showMissions().subscribe({
      next: (data) => {
        this.mission = data;
        this.allMissions = data;
        this.cdr.detectChanges();
        console.log(this.mission)
      },
      error: (err) => {
        console.log(err)
      }
    })
  }
  applyFilters(filters: { categories: number[], urgency: string[] }) {
    this.mission = this.allMissions.filter(m => {
      const categoryMatch = filters.categories.length === 0 || filters.categories.includes(m.category_id);
      const urgencyMatch = filters.urgency.length === 0 || filters.urgency.includes(m.urgency);
      return categoryMatch && urgencyMatch;
    });
}}
