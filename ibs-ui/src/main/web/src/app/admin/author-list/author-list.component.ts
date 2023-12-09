import {Component, OnInit} from '@angular/core';
import {AuthorDatasource} from "./author.datasource";
import {AuthorService} from "../../generated";
import {Router} from "@angular/router";

@Component({
  selector: 'app-author-list',
  templateUrl: './author-list.component.html',
  styleUrls: ['./author-list.component.css']
})
export class AuthorListComponent implements OnInit {
  datasource: AuthorDatasource;

  displayedColumns = ["id", "name", "birth", "death", "buttons"];

  searchId = '';

  constructor(private authorService: AuthorService,
              private router: Router) {
    this.datasource = new AuthorDatasource(this.authorService);
  }

  ngOnInit(): void {
    this.datasource.loadAuthors();
  }

  edit(item: any) {
    this.router.navigate(["/admin/author/edit/" + item.id])
  }

  delete(item: any) {
    this.authorService.deleteAuthor(item.id)
      .subscribe(data => {
        //ok
      });
  }

  add() {
    this.router.navigate(["/admin/author/new"]);
  }

  search() {
  }

}
