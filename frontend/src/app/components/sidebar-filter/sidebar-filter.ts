import { ChangeDetectorRef, Component, EventEmitter, OnInit, Output } from '@angular/core';
import { CategoryResponse } from '../../interfaces/CategoryResponse';
import { CategoryService } from '../../services/category.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-sidebar-filter',
  imports: [],
  templateUrl: './sidebar-filter.html',
  styleUrl: './sidebar-filter.css',
})
export class SidebarFilter implements OnInit{
    categories: CategoryResponse[] = [] 
    visibleCount = 5; 
    
    selectedCategory : number[] = []
    selectedUrgency: string[] = [];

    @Output() filterChanged  = new EventEmitter<{categories:number[] , urgency:string[]}>()

    constructor(private categoryService:CategoryService,private cdr:ChangeDetectorRef){}

    ngOnInit(){
      this.fetchCategory();
    }

    fetchCategory(){
      this.categoryService.getCategories().subscribe({
        next:(data) => {
          this.categories = data;
          this.cdr.detectChanges();
          console.log("category" , data);
        },
        error:(err) => {
          console.error(err);
        }
      })
    }
    get visibleCategories(): CategoryResponse[] {
    return this.categories.slice(0, this.visibleCount);
  }

  showMore() {
    this.visibleCount += 5; // reveal 5 more categories each time
  }

  toggleCategory(id:number,checked:boolean){
    if(checked) this.selectedCategory.push(id);
    else this.selectedCategory = this.selectedCategory.filter(c=>c !== id);
    this.emitFilters();
  }

  toggleUrgency(level:string,checked:boolean){
    if(checked) this.selectedUrgency.push(level);
    else this.selectedUrgency = this.selectedUrgency.filter(u => u!== level);
    this.emitFilters();
  }

  emitFilters(){
    this.filterChanged.emit({
      categories:this.selectedCategory,
      urgency:this.selectedUrgency
    })
  }
}
