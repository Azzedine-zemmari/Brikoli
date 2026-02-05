import { Component } from '@angular/core';
import { Footer } from "../components/footer/footer";
import { Categories } from "../components/categories/categories";
import { Header } from "../components/header/header";

@Component({
  selector: 'app-home',
  imports: [Footer, Categories, Header],
  templateUrl: './home.html',
  styleUrl: './home.css',
})
export class Home {

}
