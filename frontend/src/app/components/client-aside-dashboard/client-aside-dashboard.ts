import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
interface MenuItem {
  icon: string;
  label: string;
  href: string;
  active?: boolean;
  badge?: boolean; 
}
@Component({
  selector: 'app-client-aside-dashboard',
  imports: [CommonModule],
  templateUrl: './client-aside-dashboard.html',
  styleUrl: './client-aside-dashboard.css',
})
export class ClientAsideDashboard {
    menuItems: MenuItem[] = [
      { icon: 'dashboard', label: 'Tableau de bord', href: '#', active: true },
      { icon: 'briefcase_meal', label: 'Missions', href: '#' },
      { icon: 'chat_bubble', label: 'Messages', href: '#', badge: true },
      { icon: 'account_balance_wallet', label: 'Portefeuille', href: '#' },
      { icon: 'settings', label: 'Paramètres', href: '#' },
    ];
}
