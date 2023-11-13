import {Routes} from "@angular/router";
import {BookEditComponent} from "./book-edit/book-edit.component";
import {AdminComponent} from "./admin/admin.component";
import {AuthorEditComponent} from "./author-edit/author-edit.component";

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
        path: 'book/new',
        component: BookEditComponent
      },
      {
        path: 'author/edit/:id',
        component: AuthorEditComponent
      },
      {
        path: 'author/new',
        component: AuthorEditComponent
      }]
  }
]
