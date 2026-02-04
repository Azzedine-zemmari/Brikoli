import { Role } from '../enum/role.enum';

export interface RegisterDto {
    firstName: string;
    lastName: string;
    email: string;
    phone: string;
    password: string;
    role: Role;
    graduated: boolean;
}
