import {CollectionViewer, DataSource} from "@angular/cdk/collections";
import {Book, BookService} from "../../generated";
import {BehaviorSubject, Observable} from "rxjs";

export class BookDatasource extends DataSource<Book>{


  private notifySubject = new BehaviorSubject<Book[]>([]);
  //private loadingSubject: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(false);

  constructor(private bookService: BookService) {
    super();
  }
  connect(collectionViewer: CollectionViewer): Observable<Book[]> {
    return this.notifySubject.asObservable();
  }

  disconnect(collectionViewer: CollectionViewer): void {
    this.notifySubject.complete();
    //this.loadingSubject.complete();
  }

  loadBooks(){
    //this.loadingSubject.next(true);
    this.bookService.findAll().pipe(
      // catchError(() => of([])),
    ).subscribe(value => this.notifySubject.next(value))
  }

}
