import { Component } from '@angular/core';
import { myStructualComponent} from './app.myStructural'
import { myAttributeComponent} from './app.myAttributedirective'
import { myParentComponent} from './app.component.inputoutputParent'
import { myPipesComponent } from "./app,pipes";

@Component({
  selector: 'my-app',
  template: `<h1>Hello World</h1>
             <h4>Test header4 </h4>
             <my-Structual></my-Structual>
             <my-Parent></my-Parent>
             <my-pipes></my-pipes>
             `,
  styles: [`h4
  {
    color:red;
  }`]  ,
  directives:[myStructualComponent,myAttributeComponent, myParentComponent, myPipesComponent]         
})
export class AppComponent { }
