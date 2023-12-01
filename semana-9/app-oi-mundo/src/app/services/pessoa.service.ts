import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PessoaService {
  url = 'http://localhost:8080/pessoas';

  constructor(private httpClient: HttpClient) { }
}
