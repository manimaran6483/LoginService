import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { user } from 'src/app/user';
import { userresponse } from 'src/app/userresponse';
@Injectable({
  providedIn: 'root'
})
export class LoginserviceService {

  constructor(private http: HttpClient) { }
  
  private appUrl = "http://localhost:9090/api/";

   validate(data:user): Observable<userresponse> {
    return this.http.post<userresponse>(this.appUrl,data);
  }
}
