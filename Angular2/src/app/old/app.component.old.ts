import { Component } from '@angular/core';
@Component({
  selector: 'my-newApp',
  templateUrl: `app/old/app.component.old.html`,
  styles: [`input.ng-invalid{border-left:5px solid red;}
  input.ng-valid{border-left: 5px solid green;}`]     
})
export class OldAppComponent {
 myName="hemanth";
 myEmail="hk@gmail.com";
  onSubmit(value:any)
  {
    console.log(value);
  }
 }
