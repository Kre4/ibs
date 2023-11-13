import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {BookEditComponent} from './book-edit/book-edit.component';
import {RouterModule} from "@angular/router";
import {AdminRoutes} from "./admin.routing";
import {AdminComponent} from './admin/admin.component';
import { BookListComponent } from './book-list/book-list.component';
import {MatTableModule} from "@angular/material/table";
import {MatButtonModule} from "@angular/material/button";
import {MatInputModule} from "@angular/material/input";
import {MatProgressSpinnerModule} from "@angular/material/progress-spinner";
import {MatSortModule} from "@angular/material/sort";
import {MatMenuModule} from "@angular/material/menu";
import {MatIconModule} from "@angular/material/icon";
import {MatCardModule} from "@angular/material/card";
import {MatToolbarModule} from "@angular/material/toolbar";


@NgModule({
  declarations: [
    BookEditComponent,
    AdminComponent,
    BookListComponent
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
    MatToolbarModule
  ]
})
export class AdminModule { }
