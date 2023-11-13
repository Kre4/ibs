import {Component, OnInit} from '@angular/core';
import {BehaviorSubject} from "rxjs";
import {FormBuilder, FormGroup} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {Book, BookService} from "../../generated";

@Component({
  selector: 'app-book-edit',
  templateUrl: './book-edit.component.html',
  styleUrls: ['./book-edit.component.css']
})
export class BookEditComponent implements OnInit{
  loading: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(false);

  bookId: number;

  book: Book;

  formGroup: FormGroup;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private bookService: BookService,
              private formBuilder: FormBuilder) {

  }
  ngOnInit(): void {
    this.bookId = Number(this.route.snapshot.paramMap.get('id'));
    if (this.bookId){
      this.loadData()
    } else {
      this.builtFrom();
    }

    this.builtFrom();
  }

  loadData(){
    this.bookService.getBook(this.bookId).subscribe(value => {
      this.book = value;
      this.builtFrom();
    });
  }
  builtFrom(){
    this.formGroup = this.formBuilder.group({
      id: [this.book?.id],
      name: [this.book?.name],
      year: [this.book?.year],
      description: [this.book?.description],
      publisher: [this.book?.publisher]
      // todo add authors, genre, copies
    })

  }
  back(){}

  save(value: any){}

}
