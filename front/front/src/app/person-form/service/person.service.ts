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
    return this.client.post(this.url, person, { observe: 'response' });
  }

  find() {
    return this.client.get(this.url);
  }

  findById(id: string) {
    return this.client.get(`${this.url}/${id}`);
  }

  put(id: string, body: any) {
    return this.client.put(`${this.url}/${id}`, body);
  }

  delete(id: string) {
    return this.client.delete(`${this.url}/${id}`);
  }
}
