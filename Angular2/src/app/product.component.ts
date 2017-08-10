import { Component } from '@angular/core';
import { Router }  from '@angular/router'; 
import { OldAppComponent }  from './old//app.component.old';
@Component ({
   selector: 'my-app',
   template: `Products
             <button class="button" (click) = "onBack()">Back to Inventory</button>
             <my-newApp>...</my-newApp>`
              
})
export   class   Appproduct  {

 constructor(private _router: Router){} 

   onBack(): void { 
      this._router.navigate(['/Inventory']); 
   } 
}