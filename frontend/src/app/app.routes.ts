import { Routes } from '@angular/router';
import { Register } from './pages/register/register';
import { Login } from './pages/login/login';
import { Home } from './pages/home/home';
import { ClientDashboard } from './pages/client-dashboard/client-dashboard';

export const routes: Routes = [
    {
        path:"register",component:Register,
    },
    {
        path:"login", component:Login
    },
    {
        path:"home",component:Home
    },
    {
        path:"client_dashboard",component:ClientDashboard
    }   
];
