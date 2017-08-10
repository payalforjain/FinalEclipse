"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var core_1 = require("@angular/core");
var platform_browser_1 = require("@angular/platform-browser");
var app_component_1 = require("./app.component");
var app_component_old_1 = require("./old//app.component.old");
var article_component_1 = require("./article/article.component");
var forms_1 = require("@angular/forms");
var article_service_1 = require("./article/article.service");
var http_1 = require("@angular/http");
var product_component_1 = require("./product.component");
var Inventory_component_1 = require("./Inventory.component");
var router_1 = require("@angular/router");
var forms_2 = require("@angular/forms");
var product_form_component_1 = require("./product-form.component");
var appRoutes = [
    { path: 'Product', component: product_component_1.Appproduct },
    { path: 'Inventory', component: Inventory_component_1.AppInventory },
];
var AppModule = (function () {
    function AppModule() {
    }
    return AppModule;
}());
AppModule = __decorate([
    core_1.NgModule({
        imports: [platform_browser_1.BrowserModule, router_1.RouterModule.forRoot(appRoutes), http_1.HttpModule, forms_2.FormsModule, forms_1.ReactiveFormsModule],
        providers: [article_service_1.ArticleService],
        declarations: [app_component_1.AppComponent, product_component_1.Appproduct, Inventory_component_1.AppInventory, product_form_component_1.ProductFormComponent, app_component_old_1.OldAppComponent, article_component_1.ArticleComponent],
        bootstrap: [app_component_1.AppComponent],
        exports: [app_component_old_1.OldAppComponent]
    })
], AppModule);
exports.AppModule = AppModule;
//# sourceMappingURL=app.module.js.map