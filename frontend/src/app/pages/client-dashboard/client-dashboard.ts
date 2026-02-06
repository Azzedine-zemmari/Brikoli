import { Component } from '@angular/core';
import { ClientAsideDashboard } from "../../components/client-aside-dashboard/client-aside-dashboard";

@Component({
  selector: 'app-client-dashboard',
  imports: [ClientAsideDashboard],
  templateUrl: './client-dashboard.html',
  styleUrl: './client-dashboard.css',
})
export class ClientDashboard {

}
