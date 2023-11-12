import {Component, OnInit} from '@angular/core';
import {BookService} from "../../generated";
import {finalize} from "rxjs";

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
    console.log("searching")
  }

  find(){
    this.bookService.findBooksBySearch(this.search)
      //.pipe() TODO add loading animation
      .subscribe(data => {
        console.log(this.search)
      })
    //this.bookService.find();
  }

}
