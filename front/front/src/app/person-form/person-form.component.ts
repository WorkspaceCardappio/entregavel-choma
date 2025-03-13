import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable, of } from 'rxjs';
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
  person: any = {};
  error: any;

  constructor(
    private builder: FormBuilder,
    private service: PersonService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.form = this.builder.group({
      id: [''],
      name: ['', Validators.required],
      cpf: [''],
      birthDate: [''],
      phoneNumber: [''],
    });

    this.findPersonByRoute().subscribe(person => {

      if (person) this.populateForm(person);
    });
  }

  onSubmit() {
    if (this.form.valid) {
      this.service.create(this.form.value).subscribe((response) => {
        this.error = null;
        this.router.navigate(['/list']);
      }, (error) => {
        this.error = error.error.message;
      });
    }
  }

  findPersonByRoute(): Observable<any> {

    const id: string | null = this.route.snapshot.paramMap.get('id');

    if (id) {
      return this.find(id);
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
