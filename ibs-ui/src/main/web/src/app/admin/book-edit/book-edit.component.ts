import {Component, OnInit} from '@angular/core';
 import {BehaviorSubject, finalize} from "rxjs";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {Author, AuthorService, Book, BookService} from "../../generated";
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
  authors: Author[];

  constructor(private route: ActivatedRoute,
              private router: Router,
              private authorService: AuthorService,
              private bookService: BookService,
              private formBuilder: FormBuilder) {

  }
  ngOnInit(): void {
    this.bookId = Number(this.route.snapshot.paramMap.get('id'));
    this.loadDictionaries();
    if (this.bookId){
      this.loadData()
    } else {
      this.buildFrom();
    }

    this.buildFrom();
  }

  loadDictionaries() {
    this.loading.next(true);
    this.authorService.findAll()
      .pipe(finalize(() => this.loading.next(false)))
      .subscribe(data => this.authors = data);
  }

  loadData(){
    this.bookService.getBook(this.bookId).subscribe(value => {
      this.book = value;
      this.buildFrom();
    });
  }

  buildFrom(){
    this.formGroup = this.formBuilder.group({
      id: [this.book?.id],
      name: [this.book?.name, Validators.required],
      year: [this.book?.year, Validators.required],
      description: [this.book?.description],
      publisher: [this.book?.publisher],
      authors: [this.book?.authors.map(author => author.id), Validators.required]
      // todo add authors, genre, copies
    })

  }
  back(){
    this.router.navigate(["/admin/"]);
  }

  save(value: any){
    const saveObj = structuredClone(value);
    console.log(value);
    saveObj.authors = saveObj.authors.map(author => {
        return {
          id: author
        } as Author
      }
    );
    saveObj.genreList = [];
    saveObj.copies = [];
    console.log(saveObj);
    this.loading.next(true);
    this.bookService.saveBook(saveObj as Book)
      .pipe(finalize(() => this.loading.next(false)))
      .subscribe(data => {
        console.log("ok");
      })
  }

}
