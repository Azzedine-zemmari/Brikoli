import { Component } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-professional-header',
  imports: [CommonModule],
  templateUrl: './professional-header.html',
  styleUrl: './professional-header.css',
})
export class ProfessionalHeader {
  constructor(public authService : AuthService){}
}
