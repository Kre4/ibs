import {CollectionViewer, DataSource} from "@angular/cdk/collections";
import {Dictionary, GenreService} from "../../generated";
import {BehaviorSubject, catchError, finalize, Observable, of} from "rxjs";

export class GenreDatasource extends DataSource<Dictionary> {
  private notifySubject = new BehaviorSubject<Dictionary[]>([]);
  private loadingSubject: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(false);
  public loading: Observable<boolean> = this.loadingSubject.asObservable();

  constructor(private genreService: GenreService) {
    super();
  }

  connect(collectionViewer: CollectionViewer): Observable<Dictionary[]> {
    return this.notifySubject.asObservable();
  }

  disconnect(collectionViewer: CollectionViewer): void {
    this.notifySubject.complete();
    this.loadingSubject.complete();
  }

  loadAuthors() {
    this.loadingSubject.next(true);
    this.genreService.findAll()
      .pipe(
        catchError(() => of([])),
        finalize(() => this.loadingSubject.next(false))
      )
      .subscribe(value => {
        this.notifySubject.next(value);
      })
  }

}
