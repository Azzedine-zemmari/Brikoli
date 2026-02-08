export interface MissionResponse {
    id:number;
    title: string;
    description: string;
    location: string;
    client_id: number | null;
    category_id: number;
    urgency: 'ASAP' | 'NORMAL' | 'URGENT';
    missionStatus: 'COMPLETED' | 'IN_PROGRESS' | 'POSTED';
    budget_max: number | null;
    budget_min: number | null;
    created_at: string
}
