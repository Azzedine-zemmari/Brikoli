export interface MissionRequest {
    title: string;
    description: string;
    category_id: number;
    location: string;
    urgency: urgency;
    budget_min : number;
    budget_max : number;
    mission_date:string;
}
export enum urgency{
    NORMAL,
    URGENT,
    ASAP
}   