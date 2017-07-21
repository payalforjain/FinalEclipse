import { Component } from '@angular/core';
import { myChildComponent } from "./app.component.inputoutputChild";

@Component({
  selector: 'my-Parent',
  template: `<h1>Parent Component</h1>
            <label> Enter Parent App Component value</label>
            <input type="text" #ptext (keyup) ="0">
            <p>Value from Child component is  {{childData}}</p>
           
            <my-Child (childEvent)="childData=$event" [parentData]="ptext.value"></my-Child>`,
  directives:[myChildComponent]            
     

})
export class myParentComponent {

  public childData: string;
    
}

