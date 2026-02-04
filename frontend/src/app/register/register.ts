import { Component } from '@angular/core';
import { FormBuilder, Validators, ReactiveFormsModule ,FormGroup} from '@angular/forms';
import { AuthService } from '../services/auth.service';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';       

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [ReactiveFormsModule,CommonModule],
  templateUrl: './register.html',
  styleUrl: './register.css',
})
export class Register {

  registerForm : FormGroup;

  constructor(
    private fb: FormBuilder,
    private authService: AuthService,
    private router: Router
  ) {
    this.registerForm = this.fb.group({
      role: ['', Validators.required],
      name: ['', Validators.required],
      prenom: ['', Validators.required],
      tel:['', Validators.required ],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(8)]],
      diplome: [false]
    });
  }
  onSubmit(){
    if(this.registerForm.invalid) return;

    this.authService.register(this.registerForm.value).subscribe({
      next:(res) =>{
        console.log('Registration successful', res);
      },
      error: (err) => {
        console.error('Registration failed', err);
      }
    });
  }
}