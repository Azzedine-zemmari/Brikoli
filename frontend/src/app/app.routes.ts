import { Routes } from '@angular/router';
import { Register } from './pages/register/register';
import { Login } from './pages/login/login';
import { Home } from './pages/home/home';
import { ClientDashboard } from './pages/client-dashboard/client-dashboard';
import { CreateMission } from './pages/create-mission/create-mission';
import { Missions } from './pages/missions/missions';
import { MissionDescription } from './pages/mission-description/mission-description';

export const routes: Routes = [
    {
        path: "register", component: Register,
    },
    {
        path: "login", component: Login
    },
    {
        path: "home", component: Home
    },
    {
        path: "client_dashboard", component: ClientDashboard
    },
    {
        path: "cree_mission", component: CreateMission
    },
    {
        path: "missions", component: Missions
    },
    {
        path: 'mission/:id',
        component: MissionDescription
    },
    {
        path: '',
        redirectTo: 'login',
        pathMatch: 'full'
    },
];
