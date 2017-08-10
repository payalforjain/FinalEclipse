import { Component } from '@angular/core';
import { IProduct } from './product';

@Component ({
   selector: 'product-form',
   templateUrl: './form.component.html'
})

export class ProductFormComponent {
   model = new IProduct(1,'ProductA');
}