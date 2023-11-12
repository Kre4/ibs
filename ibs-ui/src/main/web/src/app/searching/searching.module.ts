import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {SearchingComponent} from './searching/searching.component';
import {RouterModule} from "@angular/router";
import {MaterialModule} from "../app.module";
import {SearchingRoutes} from "./searching.routing";
import {FormsModule} from "@angular/forms";
import {MatIconModule} from "@angular/material/icon";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import {MatButtonModule} from "@angular/material/button";


// TODO удалить его и рутес
// @NgModule({
//   imports: [
//     CommonModule,
//     RouterModule.forChild(SearchingRoutes),
//     MaterialModule,
//     FormsModule,
//     MatIconModule,
//     MatFormFieldModule,
//     MatInputModule,
//     MatButtonModule
//   ],
//   declarations: [SearchingComponent]
// })
// export class SearchingModule {
// }
