"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var core_1 = require('@angular/core');
var TutorialComponent = (function () {
    function TutorialComponent() {
        this.title = " Tutorials from Hemanth";
        this.imgAddress = "http://media2.intoday.in/indiatoday/images/stories/msd_fbsport_647_061616104643.jpg";
        this.applyClass = true;
        this.applyBlue = true;
    }
    TutorialComponent.prototype.onClick = function (value) {
        console.log("log message is" + value);
    };
    TutorialComponent = __decorate([
        core_1.Component({
            selector: 'my-Tutorial',
            template: "<h1>{{title}}</h1>\n            <img [src] = \"imgAddress\">\n            <div [class.myClass]=\"applyClass\">apply Class </div>\n            <div [style.color] =\"applyBlue?'blue':'green'\"> Blue exaple </div>\n            <input type=\"text\" #demoInput>\n            <button (click) =\"onClick(demoInput.value)\"> Click me</button>\n            <input type=\"text\" [(ngModel)]=\"fname\">\n            <input type=\"text\" [(ngModel)]=\"lname\">\n            fullName: {{fname}} {{lname}}",
            styles: [".myClass\n  {\n       color: red;\n  }"]
        }), 
        __metadata('design:paramtypes', [])
    ], TutorialComponent);
    return TutorialComponent;
}());
exports.TutorialComponent = TutorialComponent;
//# sourceMappingURL=app.myTut.js.map