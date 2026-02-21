import { urgency } from "./MissionRequest";

export interface MissionDetailsResponse {
    id: number;
    title: string;
    description: string;
    budgetMin: number;
    budgetMax: number;
    location: string;
    urgency: string;
    imageName: string;
    category: string;
    created_at:string;
    firstName: string;
    lastName: string;
    missionNumber: number;
}