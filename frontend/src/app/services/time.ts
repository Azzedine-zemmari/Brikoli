import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TimeService {

  getTimeAgo(dateString: string): string {
    const now = new Date();
    const created = new Date(dateString);

    const diffMs = now.getTime() - created.getTime();
    const diffMinutes = Math.floor(diffMs / (1000 * 60));
    const diffHours = Math.floor(diffMinutes / 60);
    const diffDays = Math.floor(diffHours / 24);

    if (diffMinutes < 60) {
      return `${diffMinutes} min ago`;
    } else if (diffHours < 24) {
      return `${diffHours} h ago`;
    } else {
      return `${diffDays} day(s) ago`;
    }
  }
}