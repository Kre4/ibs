import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutes} from './app.routing';
import {AppComponent} from './app.component';
import {MainPanelComponent} from './main-panel/main-panel.component';
import {CommonModule, HashLocationStrategy, LocationStrategy} from "@angular/common";
import {RouterModule, RouterOutlet} from "@angular/router";
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatTabsModule} from "@angular/material/tabs";
import {MatIconModule} from "@angular/material/icon";
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatButtonModule} from "@angular/material/button";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {MatMenuModule} from "@angular/material/menu";
import {MatNativeDateModule} from "@angular/material/core";

@NgModule({
  exports: [],
  providers: [],
  imports: [
    CommonModule,
    MatTabsModule,
    MatIconModule,
    MatToolbarModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    FormsModule,
    RouterOutlet,
    MatMenuModule,
    MatNativeDateModule
  ],
  declarations: [
    MainPanelComponent,
  ]
})
export class MaterialModule {

}

@NgModule({
  imports: [
    HttpClientModule,
    MaterialModule,
    BrowserModule,
    BrowserAnimationsModule,
    CommonModule,
    RouterModule.forRoot(AppRoutes, {
      useHash: false
    })
  ],
  declarations: [
    AppComponent
  ],
  providers: [
    {provide: LocationStrategy, useClass: HashLocationStrategy},
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
