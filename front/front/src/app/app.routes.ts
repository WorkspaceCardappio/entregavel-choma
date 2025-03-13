import { Routes } from '@angular/router';
import { PersonFormComponent } from './person-form/person-form.component';
import { PersonListComponent } from './person-list/person-list.component';

export const routes: Routes = [
  { path: '', redirectTo: 'list', pathMatch: 'full' },
  { path: 'list', component: PersonListComponent },
  { path: 'form', component: PersonFormComponent },
  { path: 'form/:id', component: PersonFormComponent }
];
