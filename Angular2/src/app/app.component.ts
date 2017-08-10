import { Component } from '@angular/core';
import { IProduct } from './product';
import { ProductService } from './product.service';
import { Http , Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
@Component({
  selector: 'my-app',
  templateUrl:'app/app.appcomponent.html',
   providers: [ProductService]
})
export class AppComponent  { 
    name = 'Angular';
    appTitle: String = 'Welcome';
    appStatus: Boolean = true;
   
    appList: any[] = [ {
      "ID": "1",
      "Name" : "One",
      "url": 'app/images/one.jpg'
   },

   {
      "ID": "2",
      "Name" : "Two",
      "url": 'app/images/two.jpg'
   } ];

    iproducts: IProduct[];
   constructor(private _product: ProductService) {
   }
   
   ngOnInit() : void {
      this._product.getproducts()
      .subscribe(iproducts => this.iproducts = iproducts);
   }

    appData: string[] = ["Binding", "Display", "Services"];
}
