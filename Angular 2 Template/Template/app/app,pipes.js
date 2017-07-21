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
var myPipesComponent = (function () {
    function myPipesComponent() {
        this.name = 'theJoatman';
        this.date = new Date();
    }
    myPipesComponent = __decorate([
        core_1.Component({
            selector: 'my-pipes',
            template: "<h1>pipes-Example</h1>\n             <p>{{name}}</p>\n             <p>{{name | uppercase}}<p>\n             <p>{{name | lowercase}}<p>\n             <p>{{name | slice:'2':'4'}}<p>\n             <p>{{name | replace:'the':'Hello '}}<p>\n             <p>{{8.567  | number:'1.2-3'}}<p>\n             <p>{{8.567  | number:'2.2-3'}}<p>\n             <p>{{8.567  | number:'2.4-4'}}<p>\n             <p>{{8.567  | number:'2.2-2'}}<p>\n             <p>{{date | date:'fullDate'}}</p>\n             <p>{{date | date:'shortDate'}}</p>\n             <p>{{date | date:'shortTime'}}</p>  \n             ",
        }), 
        __metadata('design:paramtypes', [])
    ], myPipesComponent);
    return myPipesComponent;
}());
exports.myPipesComponent = myPipesComponent;
//# sourceMappingURL=app,pipes.js.map