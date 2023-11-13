import {Component, OnInit} from '@angular/core';
import {BehaviorSubject} from "rxjs";
import {Author, AuthorService, BookService} from "../../generated";
import {FormBuilder, FormGroup} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-author-edit',
  templateUrl: './author-edit.component.html',
  styleUrls: ['./author-edit.component.css']
})
export class AuthorEditComponent implements OnInit{
  loading: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(false);

  authorId: number;

  author: Author;

  formGroup: FormGroup;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private authorService: AuthorService,
              private formBuilder: FormBuilder) {
  }
  ngOnInit(): void {
    this.authorId = Number(this.route.snapshot.paramMap.get('id'));
    if (this.authorId){
      this.loadData()
    } else {
      this.builtFrom();
    }
    this.builtFrom();
  }

  loadData(){
    this.authorService.getAuthor(this.authorId).subscribe(value => {
      this.author = value;
      this.builtFrom();
    });
  }
  builtFrom(){
    this.formGroup = this.formBuilder.group({
      id: [this.author?.id],
      name: [this.author?.name],
      birthDate: [this.author?.birthDate],
      deathDate: [this.author?.deathDate]
    })

  }
  back(){}

  save(value: any){
    let saveObj: Author = {};
    saveObj = structuredClone(value);
    this.authorService.saveAuthor(saveObj)
      // .pipe()
      .subscribe(value => {
        console.log(value);
      })
  }

}
