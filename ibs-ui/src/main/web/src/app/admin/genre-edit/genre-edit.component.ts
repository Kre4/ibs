import {Component, OnInit} from '@angular/core';
import {BehaviorSubject, finalize} from "rxjs";
import {Author, AuthorService, Dictionary, GenreService} from "../../generated";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-genre-edit',
  templateUrl: './genre-edit.component.html',
  styleUrls: ['./genre-edit.component.css']
})
export class GenreEditComponent implements OnInit {
  loading: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(false);

  genreId: number;

  genre: Dictionary;

  formGroup: FormGroup;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private genreService: GenreService,
              private formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
    this.genreId = Number(this.route.snapshot.paramMap.get('id'));
    if (this.genreId) {
      this.loadData()
    } else {
      this.buildFrom();
    }
    this.buildFrom();
  }

  loadData() {
    this.genreService.getGenre(this.genreId).subscribe(value => {
      this.genre = value;
      this.buildFrom();
    });
  }

  buildFrom() {
    this.formGroup = this.formBuilder.group({
      id: [this.genre?.id],
      name: [this.genre?.name, Validators.required],
      systemName: [this.genre?.systemName, Validators.required]
    })

  }

  back(){
    this.router.navigate(["/admin/"]);
  }

  save(value: any){
    this.loading.next(true);
    const saveObj: Author = structuredClone(value);
    this.genreService.saveGenre(saveObj)
      .pipe(finalize(() => this.loading.next(false)))
      .subscribe(value => {
        console.log(value);
      })
  }

}
