import {Component, OnInit} from '@angular/core';
import {AuthorDatasource} from "./author.datasource";
import {BookService} from "../../generated";
import {Router} from "@angular/router";

@Component({
  selector: 'app-author-list',
  templateUrl: './author-list.component.html',
  styleUrls: ['./author-list.component.css']
})
export class AuthorListComponent implements OnInit{
  datasource: AuthorDatasource;

  displayedColumns = ["id", "name", "birth", "death", "buttons"];

  searchId = '';

  constructor(private bookService: BookService, //todo
              private router: Router){
    this.datasource = new AuthorDatasource(this.bookService); //todo
  }
  ngOnInit(): void {
    this.datasource.loadAuthors();
  }

  edit(item: any){
  }

  delete(item: any) {
  }

  add(){
    this.router.navigate(["/admin/book/new"]);
  }

  search(){
  }

}
