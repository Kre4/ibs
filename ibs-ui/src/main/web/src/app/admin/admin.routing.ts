import {Routes} from "@angular/router";
import {BookEditComponent} from "./book-edit/book-edit.component";
import {AdminComponent} from "./admin/admin.component";

export const AdminRoutes: Routes = [
  {
    path: '',
    component: AdminComponent,
    children: [{
      path: 'edit',
      component: BookEditComponent
    }]
  }
]
