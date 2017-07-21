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
var app_component_inputoutputChild_1 = require("./app.component.inputoutputChild");
var myParentComponent = (function () {
    function myParentComponent() {
    }
    myParentComponent = __decorate([
        core_1.Component({
            selector: 'my-Parent',
            template: "<h1>Parent Component</h1>\n            <label> Enter Parent App Component value</label>\n            <input type=\"text\" #ptext (keyup) =\"0\">\n            <p>Value from Child component is  {{childData}}</p>\n           \n            <my-Child (childEvent)=\"childData=$event\" [parentData]=\"ptext.value\"></my-Child>",
            directives: [app_component_inputoutputChild_1.myChildComponent]
        }), 
        __metadata('design:paramtypes', [])
    ], myParentComponent);
    return myParentComponent;
}());
exports.myParentComponent = myParentComponent;
//# sourceMappingURL=app.component.inputoutputParent.js.map