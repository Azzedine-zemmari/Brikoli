import { Component } from '@angular/core';
import { MissionService } from '../../services/mission.service';
import { MissionRequest } from '../../interfaces/MissionRequest';
import { FormBuilder, FormGroup , Validators , ReactiveFormsModule, AbstractControl, ValidationErrors} from '@angular/forms';
import { ValidationError } from '@angular/forms/signals';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-create-mission',
  imports: [ReactiveFormsModule, CommonModule],
  templateUrl: './create-mission.html',
  styleUrl: './create-mission.css',
})
export class CreateMission {
  missionForm : FormGroup;
  backendError :string = '';
  constructor(private missionService:MissionService,private fb:FormBuilder){
    this.missionForm = this.fb.group({
      title: ['', Validators.required],
      description: ['', Validators.required],
      budget_min: [0, [Validators.required, Validators.min(1)]],
      budget_max: [0, [Validators.required, Validators.min(1)]],
      category_id: ['', Validators.required],
      location:['',Validators.required],
      urgency:['',Validators.required],
      mission_date:['',[Validators.required,this.futureOrTodayValidator]]
    },{
      validators: this.budgetValidator
    })
  }

  budgetValidator(group:AbstractControl):ValidationErrors | null{
    const min = group.get('budget_min')?.value;
    const max = group.get('budget_max')?.value;

    if (min != null && max != null && max < min) {
      return { budgetInvalid: true };
    }
    return null;
  }

    futureOrTodayValidator(control: AbstractControl): ValidationErrors | null {
      if(!control.value) return null;


      const today = new Date();
      today.setHours(0,0,0,0);

      const selectedDate = new Date(control.value);

      if(selectedDate < today){
        return {pastDate:true};
      }

      return null;
    }
  onSubmit() {
    this.backendError = '';
    console.log(this.missionForm.value);
    
    this.missionService.createMission(this.missionForm.value)
      .subscribe({
      next: (res) => {
        console.log("Mission created:", res);
      },
      error: (err) => {
          this.backendError = err.error?.message || "Something went wrong";
      }
    });
  }

}
