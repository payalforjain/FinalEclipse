import { Component } from '@angular/core';

@Component({
  selector: 'my-pipes',
  template: `<h1>pipes-Example</h1>
             <p>{{name}}</p>
             <p>{{name | uppercase}}<p>
             <p>{{name | lowercase}}<p>
             <p>{{name | slice:'2':'4'}}<p>
             <p>{{name | replace:'the':'Hello '}}<p>
             <p>{{8.567  | number:'1.2-3'}}<p>
             <p>{{8.567  | number:'2.2-3'}}<p>
             <p>{{8.567  | number:'2.4-4'}}<p>
             <p>{{8.567  | number:'2.2-2'}}<p>
             <p>{{date | date:'fullDate'}}</p>
             <p>{{date | date:'shortDate'}}</p>
             <p>{{date | date:'shortTime'}}</p>  
             `,
 
})
export class myPipesComponent {
    name='theJoatman';
    date = new Date();
 }
