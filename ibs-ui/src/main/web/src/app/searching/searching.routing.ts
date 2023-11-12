import {Routes} from "@angular/router";
import {SearchingComponent} from "./searching/searching.component";

export const SearchingRoutes: Routes = [
  {
    path: '',
    children: [{
      path: 'search',
      component:SearchingComponent
    }]
  }
]
