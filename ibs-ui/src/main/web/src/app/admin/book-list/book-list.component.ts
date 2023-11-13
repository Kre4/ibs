import {Component, OnInit} from '@angular/core';
import {BookDatasource} from "./book.datasource";
import {Author, BookService} from "../../generated";
import {Router} from "@angular/router";

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit{

  datasource: BookDatasource;

  displayedColumns = ["id", "authors", "name", "year", "publisher", "buttons"];

  searchId = '';

  constructor(private bookService: BookService,
              private router: Router){
    this.datasource = new BookDatasource(this.bookService);
  }
  ngOnInit(): void {
    this.datasource.loadBooks();
  }

  getAuthorsString( authors: Author[] ): any {
    if (authors.length != null) {
      let str = "";
      authors.forEach(author => {
        str = author.name + ' ' + str;
      })
      return str;
    } else {
      return "Неизвестен"
    }
}

  edit(item: any){
    this.router.navigate(["/admin/book/edit/" + item.id]);
  }

  delete(item: any) {
  }

  add(){
    this.router.navigate(["/admin/book/new"]);
  }

  search(){
    this.bookService.getBook(Number(this.searchId)).subscribe(
      value => {
        if (value) {
          //рутер на едит
        } else {
          // окно ошибки, что типо не найдено
        }
      }
    )
  }
}
