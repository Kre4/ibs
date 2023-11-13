import {Component, OnInit} from '@angular/core';
import {BookService} from "../../generated";

@Component({
  selector: 'app-searching',
  templateUrl: './searching.component.html',
  styleUrls: ['./searching.component.css']
})
export class SearchingComponent implements OnInit{

  search = "";

  constructor(private bookService: BookService){
  }
  ngOnInit(): void {
  }

  find(){
    this.bookService.findBooksBySearch(this.search);
      //.pipe() TODO add loading animation
    //this.bookService.find();
  }

}
