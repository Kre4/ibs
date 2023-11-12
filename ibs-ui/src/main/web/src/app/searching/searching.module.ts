import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {SearchingComponent} from './searching/searching.component';
import {RouterModule} from "@angular/router";
import {MaterialModule} from "../app.module";
import {SearchingRoutes} from "./searching.routing";


@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(SearchingRoutes),
    MaterialModule
  ],
  declarations: [SearchingComponent]
})
export class SearchingModule {
}
