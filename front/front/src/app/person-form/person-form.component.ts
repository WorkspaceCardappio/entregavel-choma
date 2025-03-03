import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { PersonService } from './service/person.service';

@Component({
  selector: 'app-person-form',
  imports: [
    ReactiveFormsModule
  ],
  providers: [
    PersonService
  ],
  templateUrl: './person-form.component.html',
  styleUrl: './person-form.component.css',
})
export class PersonFormComponent implements OnInit {

  form: FormGroup<any> = new FormGroup('');
  people: any = [];
  error: any;

  constructor(
    private builder: FormBuilder,
    private service: PersonService
  ) {}

  ngOnInit(): void {

    this.form = this.builder.group({
      id: [''],
      name: ['', Validators.required],
      cpf: [''],
      birthDate: [''],
      phoneNumber: [''],
    });

    this.find();

  }

  onSubmit() {
    if (this.form.valid) {
      this.service.create(this.form.value).subscribe(() => {
        this.find();
        this.error = null;
      }, (error) => {
        this.error = error.error.message;
      });
    }
  }

  find() {
    this.service.find().subscribe(people => {
      this.people = people;
    })
  }

}
