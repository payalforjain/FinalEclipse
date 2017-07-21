import { Component } from '@angular/core';

@Component({
  selector: 'my-Attribute',
  template: `<h1>Attribute Directive</h1>
             <p [ngClass] = "{classOne:cone, classTwo:ctwo}">ngclass Paragraph</p>
             <button (click) ="toggle()">Toggle</button>
             <p [ngStyle]="{'font-style':style, 'font-size':size}"> Style is </p>`,
  styles:[`.classOne{color:white}
           .classTwo{background-color:black}`]  
})
export class myAttributeComponent {

     public cone = true;
     public ctwo=true;
     public style ="italic";
     public size="30px";
     toggle()
     {
         this.cone= !this.cone;
         this.ctwo=!this.ctwo;
     }
   
    
}

