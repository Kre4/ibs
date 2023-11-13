import {AfterViewInit, Component, OnDestroy, OnInit} from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-main-panel',
  templateUrl: './main-panel.component.html',
  styleUrls: ['./main-panel.component.css']
})
export class MainPanelComponent implements OnInit, AfterViewInit, OnDestroy{

  constructor(private router: Router) {
  }
  ngAfterViewInit(): void {
  }

  ngOnDestroy(): void { // todo ????

  }

  ngOnInit(): void {
  }

  goToRecourse(){
    this.router.navigate(["/admin/"]);
  }

  goToMain(){
    this.router.navigate(["/"]);
  }

}
