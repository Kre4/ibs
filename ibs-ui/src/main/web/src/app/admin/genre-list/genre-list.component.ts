import {Component, OnInit} from '@angular/core';
import {GenreDatasource} from "./genre.datasource";
import {GenreService} from "../../generated";
import {Router} from "@angular/router";

@Component({
  selector: 'app-genre-list',
  templateUrl: './genre-list.component.html',
  styleUrls: ['./genre-list.component.css']
})
export class GenreListComponent implements OnInit {

  datasource: GenreDatasource;

  displayedColumns = ["id", "name", "buttons"];

  constructor(private genreService: GenreService,
              private router: Router) {
    this.datasource = new GenreDatasource(this.genreService);
  }

  ngOnInit(): void {
    this.datasource.loadAuthors();
  }

  add() {
    this.router.navigate(["/admin/genre/new"]);
  }

  edit(item: any) {
    this.router.navigate(["/admin/genre/edit/" + item.id]);
  }

  delete(item: any) {
    this.genreService.deleteGenre(item.id)
      .subscribe(data => {
        //ok
      })
  }

}
