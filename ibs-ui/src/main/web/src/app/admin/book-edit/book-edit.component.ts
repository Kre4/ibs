import {Component, OnInit} from '@angular/core';
 import {BehaviorSubject, finalize} from "rxjs";
import {FormBuilder, FormGroup} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {AuthorService, Book, BookService} from "../../generated";
import {getTreeNoValidDataSourceError} from "@angular/cdk/tree";

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
              private authorService: AuthorService,
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
      publisher: [this.book?.publisher],
      authors: [this.book?.authors[0].id]
      // todo add authors, genre, copies
    })

  }
  back(){}

  save(value: any){
    const saveObj = structuredClone(value);

    saveObj.authors = [{id: saveObj.authors}];
    saveObj.genreList = [];
    saveObj.copies = [];
    this.loading.next(true);
    this.bookService.saveBook(saveObj as Book)
      .pipe(finalize(() => this.loading.next(false)))
      .subscribe(data => {
        console.log("ok");
      })
  }

}
