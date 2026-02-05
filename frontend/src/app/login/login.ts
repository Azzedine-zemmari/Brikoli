import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../services/auth.service';
import { ReactiveFormsModule } from '@angular/forms';
import { RouterLink,RouterModule   } from '@angular/router';    


@Component({
  selector: 'app-login',
  imports: [ReactiveFormsModule,RouterModule],
  templateUrl: './login.html',
  styleUrl: './login.css',
})
export class Login {
  loginForm : FormGroup;

  constructor(
    private fb: FormBuilder,
    private authService : AuthService
  ){
    this.loginForm = this.fb.group({
      email:['',[Validators.required,Validators.email]],
      password:['',[Validators.required,Validators.minLength(8)]]
    })
  }
  onSubmit(){
    if(this.loginForm.invalid) return;

    this.authService.login(this.loginForm.value).subscribe({
      next: () => {
        console.log("login successfully")
      } ,
      error: err => {
        console.error("error")
      }
    })
  }
}
