import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-new-cmp',
  templateUrl: './new-cmp.component.html',
  styleUrls: ['./new-cmp.component.css']
})
export class NewCmpComponent implements OnInit {

  todo = ["Học Typescript", "Học Angular 4", "Học HTML5"];

  constructor() { }

  ngOnInit(): void {
  }

}
