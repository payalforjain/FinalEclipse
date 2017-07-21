import { Component } from '@angular/core';

@Component({
  selector: 'my-Tutorial',
  template: `<h1>{{title}}</h1>
            <img [src] = "imgAddress">
            <div [class.myClass]="applyClass">apply Class </div>
            <div [style.color] ="applyBlue?'blue':'green'"> Blue exaple </div>
            <input type="text" #demoInput>
            <button (click) ="onClick(demoInput.value)"> Click me</button>
            <input type="text" [(ngModel)]="fname">
            <input type="text" [(ngModel)]="lname">
            fullName: {{fname}} {{lname}}`,
  styles: [`.myClass
  {
       color: red;
  }`]           
})
export class TutorialComponent {
    public title =" Tutorials from Hemanth";
    public imgAddress="http://media2.intoday.in/indiatoday/images/stories/msd_fbsport_647_061616104643.jpg";
    public applyClass = true;
    public applyBlue = true; 
    onClick(value)
    {
        console.log("log message is" +value);
    }

    public fname;
    public lname;
}

