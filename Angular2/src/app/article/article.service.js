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
var core_1 = require("@angular/core");
var http_1 = require("@angular/http");
var rxjs_1 = require("rxjs");
require("rxjs");
var ArticleService = (function () {
    //Create constructor to get Http instance
    function ArticleService(http) {
        this.http = http;
        //URLs for CRUD operations
        this.allArticlesUrl = "http://localhost:8080/user/all-articles";
        this.articleUrl = "http://localhost:8080/user/article";
    }
    //Fetch all articles
    ArticleService.prototype.getAllArticles = function () {
        return this.http.get(this.allArticlesUrl)
            .map(this.extractData)
            .catch(this.handleError);
    };
    //Create article
    ArticleService.prototype.createArticle = function (article) {
        var cpHeaders = new http_1.Headers({ 'Content-Type': 'application/json' });
        var options = new http_1.RequestOptions({ headers: cpHeaders });
        return this.http.post(this.articleUrl, article, options)
            .map(function (success) { return success.status; })
            .catch(this.handleError);
    };
    //Fetch article by id
    ArticleService.prototype.getArticleById = function (id) {
        var cpHeaders = new http_1.Headers({ 'Content-Type': 'application/json' });
        var cpParams = new http_1.URLSearchParams();
        cpParams.set('id', id);
        var options = new http_1.RequestOptions({ headers: cpHeaders, params: cpParams });
        return this.http.get(this.articleUrl, options)
            .map(this.extractData)
            .catch(this.handleError);
    };
    //Update article
    ArticleService.prototype.updateArticle = function (article) {
        var cpHeaders = new http_1.Headers({ 'Content-Type': 'application/json' });
        var options = new http_1.RequestOptions({ headers: cpHeaders });
        return this.http.put(this.articleUrl, article, options)
            .map(function (success) { return success.status; })
            .catch(this.handleError);
    };
    //Delete article	
    ArticleService.prototype.deleteArticleById = function (id) {
        var cpHeaders = new http_1.Headers({ 'Content-Type': 'application/json' });
        var cpParams = new http_1.URLSearchParams();
        cpParams.set('id', id);
        var options = new http_1.RequestOptions({ headers: cpHeaders, params: cpParams });
        return this.http.delete(this.articleUrl, options)
            .map(function (success) { return success.status; })
            .catch(this.handleError);
    };
    ArticleService.prototype.extractData = function (res) {
        var body = res.json();
        return body;
    };
    ArticleService.prototype.handleError = function (error) {
        console.error(error.message || error);
        return rxjs_1.Observable.throw(error.status);
    };
    return ArticleService;
}());
ArticleService = __decorate([
    core_1.Injectable(),
    __metadata("design:paramtypes", [http_1.Http])
], ArticleService);
exports.ArticleService = ArticleService;
//# sourceMappingURL=article.service.js.map