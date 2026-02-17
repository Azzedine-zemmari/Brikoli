import { Component } from '@angular/core';
import { MissionService } from '../../services/mission.service';
import { MissionRequest } from '../../interfaces/MissionRequest';
import { FormBuilder, FormGroup , Validators , ReactiveFormsModule} from '@angular/forms';

@Component({
  selector: 'app-create-mission',
  imports: [ReactiveFormsModule],
  templateUrl: './create-mission.html',
  styleUrl: './create-mission.css',
})
export class CreateMission {
  missionForm : FormGroup;
  constructor(private missionService:MissionService,private fb:FormBuilder){
    this.missionForm = this.fb.group({
      title: ['', Validators.required],
      description: ['', Validators.required],
      budget_min: [0, Validators.required],
      budget_max: [0, Validators.required],
      category_id: ['', Validators.required],
      location:['',Validators.required],
      date:['',Validators.required],
      urgency:['',Validators.required]
    })
  }
  onSubmit() {
    this.missionService.createMission(this.missionForm.value)
      .subscribe({
      next: (res) => {
        console.log("Mission created:", res);
      },
      error: (err) => {
        console.error("Error:", err);
      }
    });
  }

}
