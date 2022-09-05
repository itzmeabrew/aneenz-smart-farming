import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { GoogleLoginProvider, SocialAuthService } from 'angularx-social-login';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit
{

  login_form: FormGroup = new FormGroup({
    username: new FormControl(null,
      [
        Validators.required,
        Validators.maxLength(45)
      ]),

      password: new FormControl(null,
      [
        Validators.required,
        Validators.maxLength(45)
      ]),
  })

  constructor(private loginx: LoginService, private socialAuthService: SocialAuthService) { }

  ngOnInit(): void { }

  public login_function():void
  {
    this.loginx.loginx(this.login_form.value).subscribe(
      response =>
      {
        console.log(response);
      },
      error =>
      {
        // TODO document why this arrow function is empty
        console.error(error);
      }
    )
  }

  public loginWithGoogle(): void
  {
    this.socialAuthService.signIn(GoogleLoginProvider.PROVIDER_ID).then(
      (response) =>
      {
        console.log(response);
      },

      (error) =>
      {
        console.error(error);
      });
  }

}
