import {Routes} from "@angular/router";
import {BookEditComponent} from "./book-edit/book-edit.component";
import {AdminComponent} from "./admin/admin.component";
import {BookListComponent} from "./book-list/book-list.component";

export const AdminRoutes: Routes = [
  {
    path: '',
    component: AdminComponent,
    children: [
      {
      path: 'book/edit/:id',
      component: BookEditComponent
      },
      {
        path: 'book/list',
        component: BookListComponent
      }]
  }
]
