import {Routes} from '@angular/router';
import {MainPanelComponent} from "./main-panel/main-panel.component";

export const AppRoutes: Routes = [
  {
    path: '',
    component: MainPanelComponent,
    //data: {roles: ['user', 'superuser', 'admin']} TODO auth
    children: [
      {
        path: 'main',
        loadChildren: () => import('./searching/searching.module').then(m => m.SearchingModule)
      }
    ]
  }
];
