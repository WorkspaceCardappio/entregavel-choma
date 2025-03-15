import {Component, OnInit} from '@angular/core';
import {FormGroup, ReactiveFormsModule} from '@angular/forms';
import {Router} from '@angular/router';
import {PersonService} from '../person-form/service/person.service';
import {DatePipe} from '@angular/common';
import {CPFPipe} from '../config/cpf.pipe';
import {PhoneNumberPipe} from '../config/phone-number.pipe';

@Component({
  selector: 'app-person-list',
  imports: [
    ReactiveFormsModule,
    DatePipe,
    CPFPipe,
    PhoneNumberPipe
  ],
  providers: [
    PersonService,
  ],
  templateUrl: './person-list.component.html',
  styleUrl: './person-list.component.css',
})
export class PersonListComponent implements OnInit {

  form: FormGroup<any> = new FormGroup('');
  people: any = [];

  constructor(
    private service: PersonService,
    private router: Router,
  ) {}

  ngOnInit(): void {
    this.find();
  }

  find() {
    this.service.find().subscribe(people => {

      this.people = people;
    });
  }

  goToForm() {
    this.router.navigate(['/form']);
  }

  goToFormWithId(id: number) {
    this.router.navigate(['/form', id]);
  }

  delete(id: string) {
    this.service.delete(id).subscribe(() => this.find());
  }


}
