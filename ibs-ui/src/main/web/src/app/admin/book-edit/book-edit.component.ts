import {Component, OnInit} from '@angular/core';
import {BehaviorSubject} from "rxjs";

@Component({
  selector: 'app-book-edit',
  templateUrl: './book-edit.component.html',
  styleUrls: ['./book-edit.component.css']
})
export class BookEditComponent implements OnInit{
  loading: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(false);

  book: null;

  // formGroup: FormGroup;

  constructor() {
    this.book = null;
  }
  ngOnInit(): void {
    console.log("book edit")
  }

}
