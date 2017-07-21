import { Component } from '@angular/core';
import { EventEmitter} from '@angular/core';

@Component({
  selector: 'my-Child',
  template: `<h1>Child Component</h1>
            <label> Enter Child App Component value</label>
            <input type="text" #childtext (keyup)= "onChange(childtext.value)">
            <p>Value from Parent component is  {{parentData}}</p>`,
  inputs: ['parentData'],
  outputs: ['childEvent']
})
export class myChildComponent {
   public parentData: String;
   childEvent = new EventEmitter<String>();
   onChange(value:string){
     this.childEvent.emit(value);
   }

    
}

