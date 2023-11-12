import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutes } from './app.routing';
import { AppComponent } from './app.component';
import { MainPanelComponent } from './main-panel/main-panel.component';
import {CommonModule} from "@angular/common";
import {RouterModule} from "@angular/router";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatTabsModule} from "@angular/material/tabs";
import {MatIconModule} from "@angular/material/icon";
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatButtonModule} from "@angular/material/button";

@NgModule({
  exports: [],
  providers: [],
  imports: [
    CommonModule,
    BrowserAnimationsModule,
    MatTabsModule,
    MatIconModule,
    MatToolbarModule,
    MatButtonModule
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
