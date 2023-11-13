import {Component, OnInit} from '@angular/core';
import {Author, BookService} from "../../generated";
import {BookDatasource} from "../../admin/book-list/book.datasource";

@Component({
  selector: 'app-searching',
  templateUrl: './searching.component.html',
  styleUrls: ['./searching.component.css']
})
export class SearchingComponent implements OnInit {

  search = "";

  dataSource: BookDatasource;

  displayedColumns = ["authors", "name", "year", "publisher"];

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
    console.log(authors)
    if (authors) {
      let str = "";
      authors.forEach(author => {
        str += author.name + ' ' + str;
      });
      return str;
    } else {
      return "Неизвестен"
    }
  }

}
