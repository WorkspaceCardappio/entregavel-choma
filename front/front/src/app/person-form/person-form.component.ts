import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { catchError, Observable, of, switchMap } from 'rxjs';
import { PersonService } from './service/person.service';

@Component({
  selector: 'app-person-form',
  imports: [
    ReactiveFormsModule
  ],
  providers: [
    PersonService,
  ],
  templateUrl: './person-form.component.html',
  styleUrl: './person-form.component.css',
})
export class PersonFormComponent implements OnInit {

  form: FormGroup<any> = new FormGroup('');
  error: any;
  id: string | null | undefined;

  constructor(
    private builder: FormBuilder,
    private service: PersonService,
    private router: Router,
    private route: ActivatedRoute,
  ) {}

  ngOnInit(): void {

    this.id = this.route.snapshot.paramMap.get('id');

    this.form = this.builder.group({
      id: [''],
      name: ['', Validators.required],
      cpf: [''],
      birthDate: [''],
      phoneNumber: [''],
      email: [''],
    });

    this.findPersonByRoute().subscribe(person => {

      if (person) this.populateForm(person);
    });
  }

  onSubmit() {
    if (this.form.valid) {
      let person = this.form.value;

      this.id
        ? this.update(this.id, person)
        : this.create(person);
    }
  }

  create(person: any) {
    this.service.create(person).pipe(
      switchMap(() => {
        this.error = null;
        this.router.navigate(['/list']);
        return [];
      }),
      catchError((error) => {
        this.error = error.error.message;
        throw error;
      })
    ).subscribe();
  }

  update(id: string, person: any) {

    this.service.put(id, person).pipe(
      switchMap(() => {
        this.error = null;
        this.router.navigate(['/list']);
        return [];
      }),
      catchError((error) => {
        this.error = error.error.message;
        throw error;
      })
    ).subscribe();
  }

  findPersonByRoute(): Observable<any> {

    if (this.id) {
      return this.find(this.id);
    }

    return of();
  }

  find(id: string) {
    return this.service.findById(id);
  }

  populateForm(person: any) {
    this.form.patchValue(person);
  }
}
