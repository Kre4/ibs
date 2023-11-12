import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutes } from './app.routing';
import { AppComponent } from './app.component';
import { MainPanelComponent } from './main-panel/main-panel.component';
import {CommonModule} from "@angular/common";
import {RouterModule} from "@angular/router";

@NgModule({
  exports: [],
  providers: [],
  imports: [
    CommonModule
  ],
  declarations: [
    MainPanelComponent
  ]
})
export class MaterialModule {

}
@NgModule({
  imports: [
    MaterialModule,
    BrowserModule,
    CommonModule,
    RouterModule.forRoot(AppRoutes, {})
  ],
  declarations: [
    AppComponent
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
