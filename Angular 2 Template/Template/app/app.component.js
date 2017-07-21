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
var app_myStructural_1 = require('./app.myStructural');
var app_myAttributedirective_1 = require('./app.myAttributedirective');
var app_component_inputoutputParent_1 = require('./app.component.inputoutputParent');
var app_pipes_1 = require("./app,pipes");
var AppComponent = (function () {
    function AppComponent() {
    }
    AppComponent = __decorate([
        core_1.Component({
            selector: 'my-app',
            template: "<h1>Hello World</h1>\n             <h4>Test header4 </h4>\n             <my-Structual></my-Structual>\n             <my-Parent></my-Parent>\n             <my-pipes></my-pipes>\n             ",
            styles: ["h4\n  {\n    color:red;\n  }"],
            directives: [app_myStructural_1.myStructualComponent, app_myAttributedirective_1.myAttributeComponent, app_component_inputoutputParent_1.myParentComponent, app_pipes_1.myPipesComponent]
        }), 
        __metadata('design:paramtypes', [])
    ], AppComponent);
    return AppComponent;
}());
exports.AppComponent = AppComponent;
//# sourceMappingURL=app.component.js.map