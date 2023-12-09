import {Component, OnInit} from '@angular/core';
import {BehaviorSubject, finalize, forkJoin} from "rxjs";
import {FormArray, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {
  Author,
  AuthorService,
  Book,
  BookCopy,
  BookService,
  BookStatusService,
  Dictionary,
  GenreService
} from "../../generated";

@Component({
  selector: 'app-book-edit',
  templateUrl: './book-edit.component.html',
  styleUrls: ['./book-edit.component.css']
})
export class BookEditComponent implements OnInit {
  loading: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(false);

  bookId: number;

  book: Book;

  formGroup: FormGroup;
  authors: Author[];
  genres: Dictionary[];
  statuses: Dictionary[];

  copies: FormArray;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private authorService: AuthorService,
              private bookService: BookService,
              private genreService: GenreService,
              private bookStatusService: BookStatusService,
              private formBuilder: FormBuilder) {

  }

  ngOnInit(): void {
    this.bookId = Number(this.route.snapshot.paramMap.get('id'));
    this.loadDictionaries();
    if (this.bookId) {
      this.loadData()
    } else {
      this.buildFrom();
    }

    this.buildFrom();
  }

  loadDictionaries() {
    this.loading.next(true);
    forkJoin([this.authorService.findAll(), this.genreService.findAll(), this.bookStatusService.findAll()])
      .pipe(finalize(() => this.loading.next(false)))
      .subscribe(([authors, genres, statuses]) => {
        this.genres = genres;
        this.authors = authors;
        this.statuses = statuses;
      });
  }

  loadData() {
    this.bookService.getBook(this.bookId).subscribe(value => {
      this.book = value;
      this.buildFrom();
    });
  }

  buildFrom() {
    this.copies = this.formBuilder.array([]);
    this.formGroup = this.formBuilder.group({
      id: [this.book?.id],
      name: [this.book?.name, Validators.required],
      year: [this.book?.year, Validators.required],
      description: [this.book?.description],
      publisher: [this.book?.publisher],
      authors: [this.book?.authors.map(author => author.id), Validators.required],
      genreList: [this.book?.genreList.map(genre => genre.id), Validators.required],
      copies: this.copies
    })

  }

  addBookCopy(copy) {
    const row = this.formBuilder.group({
      id: [copy?.id ?? null],
      systemId: [copy?.systemId ?? null, []],
      status: [copy?.status ?? null, Validators.required],
    });
    this.copies.push(row);
  }

  getBookCopy(index) {
    console.log(this.formGroup.controls['copies']['controls'][index].value.id)
    return this.formGroup.controls['copies']['controls'][index].value
  }

  getCopiesCount() {
    return this.copies.value.length
  }

  back() {
    this.router.navigate(["/admin/"]);
  }

  save(value: any) {
    console.log(value);
    const saveObj = structuredClone(value);
    console.log(saveObj);
    saveObj.authors = saveObj.authors.map(author => {
        return {
          id: author
        } as Author
      }
    );
    saveObj.genreList = saveObj.genreList.map(genre => {
      return {
        id: genre
      } as Dictionary
    });

    console.log(saveObj);
    // saveObj.copies = [];
    saveObj.copies = saveObj.copies.map(copy => {
      return {
        id: copy.id,
        systemId: copy.systemId,
        status: {id: copy.status}
      } as BookCopy
    })
    this.loading.next(true);
    this.bookService.saveBook(saveObj as Book)
      .pipe(finalize(() => this.loading.next(false)))
      .subscribe(data => {
        console.log("ok");
      })
  }

}
