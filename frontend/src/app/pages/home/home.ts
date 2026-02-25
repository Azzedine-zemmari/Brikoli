import { Component } from '@angular/core';
import { Footer } from "../../components/footer/footer";
import { Categories } from "../../components/categories/categories";
import { Header } from "../../components/header/header";
import { AuthService } from '../../services/auth.service';
import { CommonModule } from '@angular/common';
import { ProfessionalHeader } from "../../components/professional-header/professional-header";

@Component({
  selector: 'app-home',
  imports: [Footer, Categories, Header, CommonModule, ProfessionalHeader],
  templateUrl: './home.html',
  styleUrl: './home.css',
})
export class Home {
  constructor(public authService:AuthService){}

}
