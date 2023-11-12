import {Routes} from '@angular/router';
import {MainPanelComponent} from "./main-panel/main-panel.component";
import {SearchingComponent} from "./searching/searching/searching.component";

export const AppRoutes: Routes = [
  {
    path: '',
    component: MainPanelComponent,
    data: {title: 'ИБС'},
    //data: {roles: ['user', 'superuser', 'admin']} TODO auth
    children: [
      {
        path: '',
        component: SearchingComponent
        //loadChildren: () => import('./searching/searching.module').then(m => m.SearchingModule)
      }
    ]
  }
];
