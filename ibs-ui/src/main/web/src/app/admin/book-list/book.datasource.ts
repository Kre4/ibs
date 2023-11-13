import {CollectionViewer, DataSource} from "@angular/cdk/collections";
import {Book, BookService} from "../../generated";
import {BehaviorSubject, catchError, finalize, Observable, of} from "rxjs";

export class BookDatasource extends DataSource<Book>{


  private notifySubject = new BehaviorSubject<Book[]>([]);
  private loadingSubject: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(false);
  public loading: Observable<boolean> = this.loadingSubject.asObservable();

  constructor(private bookService: BookService) {
    super();
  }
  connect(collectionViewer: CollectionViewer): Observable<Book[]> {
    return this.notifySubject.asObservable();
  }

  disconnect(collectionViewer: CollectionViewer): void {
    this.notifySubject.complete();
    this.loadingSubject.complete();
  }

  loadBooks(){
    this.loadingSubject.next(true);
    this.bookService.findAll()
      .pipe(
        catchError(() => of([])),
        finalize(() => this.loadingSubject.next(false))
      )
      .subscribe(value => {
      this.notifySubject.next(value);
    })
  }

  loadBySearch(search: string) {
    this.loadingSubject.next(true);
    this.bookService.findBooksBySearch(search)
      .pipe(
        catchError(() => of([])),
        finalize(() => this.loadingSubject.next(false))
      ).subscribe(value => this.notifySubject.next(value))
  }

}
