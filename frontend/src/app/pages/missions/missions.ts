import { Component } from '@angular/core';
import { ProfessionalHeader } from "../../components/professional-header/professional-header";
import { SidebarFilter } from '../../components/sidebar-filter/sidebar-filter';

@Component({
  selector: 'app-missions',
  imports: [ProfessionalHeader,SidebarFilter],
  templateUrl: './missions.html',
  styleUrl: './missions.css',
})
export class Missions {

}
