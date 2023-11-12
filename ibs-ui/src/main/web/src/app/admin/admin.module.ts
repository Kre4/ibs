import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {BookEditComponent} from './book-edit/book-edit.component';
import {RouterModule} from "@angular/router";
import {AdminRoutes} from "./admin.routing";
import {AdminComponent} from './admin/admin.component';
import { BookListComponent } from './book-list/book-list.component';
import {MatTableModule} from "@angular/material/table";


@NgModule({
  declarations: [
    BookEditComponent,
    AdminComponent,
    BookListComponent
  ],
    imports: [
        CommonModule,
        RouterModule.forChild(AdminRoutes),
        MatTableModule
    ]
})
export class AdminModule { }
