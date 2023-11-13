import {CollectionViewer, DataSource} from "@angular/cdk/collections";
import {Author, Book, BookService} from "../../generated";
import {BehaviorSubject, catchError, finalize, Observable, of} from "rxjs";

export class AuthorDatasource extends DataSource<Book> {
  private notifySubject = new BehaviorSubject<Author[]>([]);
  private loadingSubject: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(false);
  public loading: Observable<boolean> = this.loadingSubject.asObservable();
  constructor(private authorService: BookService) { //todo
    super();
  }
  connect(collectionViewer: CollectionViewer): Observable<Author[]> {
    return this.notifySubject.asObservable();
  }

  disconnect(collectionViewer: CollectionViewer): void {
    this.notifySubject.complete();
    this.loadingSubject.complete();
  }

  loadAuthors(){
    this.loadingSubject.next(true);
    this.authorService.findAll() //todo
      .pipe(
        catchError(() => of([])),
        finalize(() => this.loadingSubject.next(false))
      )
      .subscribe(value => {
        this.notifySubject.next(value);
      })
  }

}
