import {Component, OnInit} from '@angular/core';
import {BookDatasource} from "./book.datasource";
import {Author, BookService} from "../../generated";

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit{

  datasource: BookDatasource;

  displayedColumns = ["id", "authors", "name", "year", "buttons"];

  constructor(private bookService: BookService){
    this.datasource = new BookDatasource(this.bookService);
  }
  ngOnInit(): void {
    this.loadData();
  }

  ngAfterViewInit(): void {

  }

  getAuthorsString( authors: Author[] ): any {
    if (authors.length != null) {
      let str = "";
      authors.forEach(author => {
        str = author.name + ' ' + str;
        return str;
      })
    } else {
      return "Неизвестен"
    }
}

  private loadData(){
    this.datasource.loadBooks();
    console.log(this.datasource);
  }

  edit(item: any){
  }

  delete(item: any) {
  }

  add(){
  }
  }
