import { Component } from '@angular/core';
import { PersonFormComponent } from "./person-form/person-form.component";

@Component({
  selector: 'app-root',
  imports: [PersonFormComponent],
  providers: [
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'front';
}
