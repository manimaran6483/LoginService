import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LoginserviceService } from './services/login/loginservice.service';
import { user } from './user';
import { FormsModule } from '@angular/forms';
import { ɵangular_packages_platform_browser_platform_browser_d } from '@angular/platform-browser';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  formdata:any;
  u:user={username:'',password:''};
  result = '';
  showMessage=false;
  showError=false;
  constructor(private loginService: LoginserviceService,
    private router: Router) { }


  onSubmit(formdata:any) {
    console.log(formdata.value.username);
    this.u.username=formdata.value.username;
    this.u.password=formdata.value.password;
    this.loginService.validate(this.u).subscribe(data => {
      this.result = data.message;
      this.showMessage=true;
    });

  }
  onChange(event:any){

    var password = event.target.value.toString();
    console.log(password);
    var pattern = new RegExp(
      "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)"
    );
    if(password.length<8 || !pattern.test(password)){
      this.showError=true;
    }else{
      this.showError=false;
      
    }
    
  }
}
