import {Routes} from '@angular/router';
import {MainPanelComponent} from "./main-panel/main-panel.component";

export const AppRoutes: Routes = [
  {
    path: '',
    redirectTo: 'search',
    pathMatch: 'full',
  },
  {
    path: '',
    component: MainPanelComponent,
    data: {title: 'ИБС'},
    //data: {roles: ['user', 'superuser', 'admin']} TODO auth
    children: [
      {
        path: '',
        loadChildren: () => import('./searching/searching.module').then(m => m.SearchingModule)
      },
      {
        path: 'admin',
        loadChildren: () => import('./admin/admin.module').then(m => m.AdminModule)
      }
    ]
  }
];
