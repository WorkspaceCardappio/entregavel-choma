import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class PersonService {

  readonly url = "http://localhost:8080/api/clients"

  constructor(
    private client: HttpClient
  ) {}

  create(person: any) {
    return this.client.post(this.url, person);
  }

  find() {
    return this.client.get(this.url);
  }
}
