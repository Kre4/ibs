import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {BookEditComponent} from './book-edit/book-edit.component';
import {RouterModule} from "@angular/router";
import {AdminRoutes} from "./admin.routing";
import {AdminComponent} from './admin/admin.component';


@NgModule({
  declarations: [
    BookEditComponent,
    AdminComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(AdminRoutes)
  ]
})
export class AdminModule { }
