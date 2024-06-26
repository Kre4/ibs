import {Component, OnInit} from '@angular/core';
import {Author, BookService, Dictionary} from "../../generated";
import {BookDatasource} from "../../admin/book-list/book.datasource";

@Component({
  selector: 'app-searching',
  templateUrl: './searching.component.html',
  styleUrls: ['./searching.component.css']
})
export class SearchingComponent implements OnInit {

  search = "";

  dataSource: BookDatasource;

  displayedColumns = ["authors", "name", "genre","year", "publisher", "amount"];

  constructor(private bookService: BookService) {
    this.dataSource = new BookDatasource(this.bookService);
  }

  ngOnInit(): void {
  }

  find() {
    this.dataSource.loadBySearch(this.search);
      // this.bookService.findBooksBySearch(this.search)
      //   .subscribe(data => {
      //     console.log(this.search)
      //   });
    //.pipe() TODO add loading animation
    //this.bookService.find();
  }

  getAuthorsString(authors: Author[]): any {
    if (authors && authors.length > 0) {
      let str = "";
      authors.forEach(author => {
        str += author.name + ', ';
      });
      return str.slice(0, -2);
    } else {
      return "Неизвестен"
    }
  }

  getGenreString(genres: Dictionary[]): string {
    if (genres && genres.length > 0) {
      let str = "";
      genres.forEach(genre => {
        str += genre.name + ', ';
      });
      return str.slice(0, -2);
    } else {
      return "Не указан"
    }
  }

}
