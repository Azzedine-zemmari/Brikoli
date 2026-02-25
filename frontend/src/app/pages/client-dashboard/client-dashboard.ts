import { Component, OnInit, ChangeDetectorRef, inject } from '@angular/core';
import { ClientAsideDashboard } from "../../components/client-aside-dashboard/client-aside-dashboard";
import { MissionResponse } from '../../interfaces/MissionResponse';
import { MissionService } from '../../services/mission.service';
import { CommonModule, DatePipe } from '@angular/common';
import { AuthService } from '../../services/auth.service';
import { AuthUser } from '../../interfaces/AuthUser';
@Component({
  selector: 'app-client-dashboard',
  imports: [ClientAsideDashboard, CommonModule],
  templateUrl: './client-dashboard.html',
  styleUrl: './client-dashboard.css',
})
export class ClientDashboard implements OnInit {
  public missions: MissionResponse[] = [];
  public postedmission: number = 0;
  public encoursmission: number = 0;
  public completedmission: number = 0;
  public currentUser!: AuthUser;

  constructor(private missionService: MissionService, private cdr: ChangeDetectorRef, private authService: AuthService) { }


  ngOnInit(): void {
    this.fetchMissions();
    this.fetchNumberOfPostedMission();
    this.fetchNumberOfCompletedMission();
    this.fetchNumberOfEncoursMission()

    this.authService.authenticatedUser().subscribe(user => {
      this.currentUser = user;
      console.log("current user " , this.currentUser.firstName )
    })
  }

  fetchMissions(): void {
    this.missionService.showAll().subscribe({
      next: (data) => {
        this.missions = data;
        this.cdr.detectChanges();
        console.log("missions : ", this.missions);
        console.log("data : ", data);
      },
      error: (err) => {
        console.error(err);
      }
    })
  }
  fetchNumberOfPostedMission() {
    this.missionService.countPosted().subscribe({
      next: (data) => {
        this.postedmission = data;
        console.log("postedmission : ", data);
        this.cdr.detectChanges();
      }
    })
  }
  fetchNumberOfEncoursMission() {
    this.missionService.countEncours().subscribe({
      next: (data) => {
        this.encoursmission = data;
        console.log("postedmission : ", data);
        this.cdr.detectChanges();
      }
    })
  }
  fetchNumberOfCompletedMission() {
    this.missionService.countCompleted().subscribe({
      next: (data) => {
        this.completedmission = data;
        console.log("postedmission : ", data);
        this.cdr.detectChanges();
      }
    })
  }
  trackById(index: number, mission: MissionResponse) {
    return mission.id;
  }
}
