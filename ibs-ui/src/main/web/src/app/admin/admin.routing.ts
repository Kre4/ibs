import {Routes} from "@angular/router";
import {BookEditComponent} from "./book-edit/book-edit.component";
import {AdminComponent} from "./admin/admin.component";
import {AuthorEditComponent} from "./author-edit/author-edit.component";
import {ResourceTabsComponent} from "./resource-tabs/resource-tabs.component";
import {GenreEditComponent} from "./genre-edit/genre-edit.component";

export const AdminRoutes: Routes = [
  {
    path: '',
    component: AdminComponent,
    children: [
      {
        path: '',
        component: ResourceTabsComponent
      },
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
      },
      {
        path: 'genre/new',
        component: GenreEditComponent
      },
      {
        path: 'genre/edit/:id',
        component: GenreEditComponent
      }

      ],
  }
]
