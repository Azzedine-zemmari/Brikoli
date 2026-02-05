import { Component } from '@angular/core';
import { FormBuilder, Validators, ReactiveFormsModule ,FormGroup} from '@angular/forms';
import { AuthService } from '../services/auth.service';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';   
import { RouterLink,RouterModule   } from '@angular/router';    

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [ReactiveFormsModule,CommonModule,RouterModule],
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
      lastName: ['', Validators.required],
      firstName: ['', Validators.required],
      phone:['', Validators.required ],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(8)]],
      graduated: [false]
    });
  }
  onSubmit(){
    if(this.registerForm.invalid) return;

    this.authService.register(this.registerForm.value).subscribe({
      next:(res) =>{
        console.log('Registration successful', res);
        this.registerForm.reset({
        role: '',       // default value for select
        lastName: '',
        firstName: '',
        phone: '',
        email: '',
        password: '',
        graduated: false  
      });
      },
      error: (err) => {
        console.error('Registration failed', err);
      }
    });
  }
}