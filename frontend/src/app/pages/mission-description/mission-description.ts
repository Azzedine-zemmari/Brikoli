import { ChangeDetectorRef, Component } from '@angular/core';
import { MissionService } from '../../services/mission.service';
import { ActivatedRoute } from '@angular/router';
import { MissionResponse } from '../../interfaces/MissionResponse';
import { SafeUrlPipe } from '../../safe-url-pipe';
import { TimeService } from '../../services/time';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-mission-description',
  imports: [SafeUrlPipe,CommonModule],
  templateUrl: './mission-description.html',
  styleUrl: './mission-description.css',
})
export class MissionDescription {
  mission? : MissionResponse;
  constructor(
    private route: ActivatedRoute,
    private missionService: MissionService,
    public timeService:TimeService,
    private cdr:ChangeDetectorRef
  ) { }
  ngOnInit(): void {
    this.loadData();
  }
  loadData(){
    const id = this.route.snapshot.paramMap.get('id');

    if (id) {
      this.missionService.getMissionById(+id)
        .subscribe(res => {
          this.mission = res;
          this.cdr.detectChanges();
          console.log("mission details " , this.mission);
        });
    }
  }
}