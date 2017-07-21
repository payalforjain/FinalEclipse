import { Component } from '@angular/core';

@Component({
  selector: 'my-Structual',
  template: `<h1>Structural Directive</h1>
             <p *ngIf="showElement">Show element</p>
             <ul>
               <li *ngFor="let color of colors">{{color}}</li>
             </ul>
             <div [ngSwitch]="color">
                <p *ngSwitchWhen="'red'"> Red color is Shown</p>
                <p *ngSwitchWhen="'green'"> green color is Shown</p>
                <p *ngSwitchWhen="'blue'"> blue color is Shown</p>
                <p *ngSwitchDefault> default color is Shown</p>
             </div>`,
          
})
export class myStructualComponent {

    public showElement=false;
    public colors=['red', 'blue','green'];
    public color='grey';
   
    
}

