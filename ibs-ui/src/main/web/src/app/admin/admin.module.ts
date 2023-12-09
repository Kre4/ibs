import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {BookEditComponent} from './book-edit/book-edit.component';
import {RouterModule} from "@angular/router";
import {AdminRoutes} from "./admin.routing";
import {AdminComponent} from './admin/admin.component';
import {BookListComponent} from './book-list/book-list.component';
import {MatTableModule} from "@angular/material/table";
import {MatButtonModule} from "@angular/material/button";
import {MatInputModule} from "@angular/material/input";
import {MatProgressSpinnerModule} from "@angular/material/progress-spinner";
import {MatSortModule} from "@angular/material/sort";
import {MatMenuModule} from "@angular/material/menu";
import {MatIconModule} from "@angular/material/icon";
import {MatCardModule} from "@angular/material/card";
import {MatToolbarModule} from "@angular/material/toolbar";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MatTabsModule} from "@angular/material/tabs";
import {AuthorListComponent} from './author-list/author-list.component';
import {AuthorEditComponent} from './author-edit/author-edit.component';
import {ResourceTabsComponent} from './resource-tabs/resource-tabs.component';
import {MatDatepickerModule} from "@angular/material/datepicker";
import {MatSelectModule} from "@angular/material/select";
import { GenreListComponent } from './genre-list/genre-list.component';
import { GenreEditComponent } from './genre-edit/genre-edit.component';
import {MatDividerModule} from "@angular/material/divider";


@NgModule({
  declarations: [
    BookEditComponent,
    AdminComponent,
    BookListComponent,
    AuthorListComponent,
    AuthorEditComponent,
    ResourceTabsComponent,
    GenreListComponent,
    GenreEditComponent,
  ],
    imports: [
        CommonModule,
        RouterModule.forChild(AdminRoutes),
        MatTableModule,
        MatButtonModule,
        MatInputModule,
        MatProgressSpinnerModule,
        MatSortModule,
        MatMenuModule,
        MatIconModule,
        MatCardModule,
        MatToolbarModule,
        FormsModule,
        MatTabsModule,
        ReactiveFormsModule,
        MatDatepickerModule,
        MatSelectModule,
        MatDividerModule
    ],
  exports: [
    BookListComponent
  ],
})
export class AdminModule {
}
