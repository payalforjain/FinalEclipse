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
var forms_1 = require("@angular/forms");
var article_service_1 = require("./article.service");
var article_1 = require("./article");
var ArticleComponent = (function () {
    //Create constructor to get service instance
    function ArticleComponent(articleService) {
        this.articleService = articleService;
        this.requestProcessing = false;
        this.articleIdToUpdate = null;
        this.processValidation = false;
        //Create form
        this.articleForm = new forms_1.FormGroup({
            title: new forms_1.FormControl('', forms_1.Validators.required),
            category: new forms_1.FormControl('', forms_1.Validators.required)
        });
    }
    //Create ngOnInit() and and load articles
    ArticleComponent.prototype.ngOnInit = function () {
        this.getAllArticles();
    };
    //Fetch all articles
    ArticleComponent.prototype.getAllArticles = function () {
        var _this = this;
        this.articleService.getAllArticles()
            .subscribe(function (data) { return _this.allArticles = data; }, function (errorCode) { return _this.statusCode = errorCode; });
    };
    //Handle create and update article
    ArticleComponent.prototype.onArticleFormSubmit = function () {
        var _this = this;
        this.processValidation = true;
        if (this.articleForm.invalid) {
            return; //Validation failed, exit from method.
        }
        //Form is valid, now perform create or update
        this.preProcessConfigurations();
        var title = this.articleForm.get('title').value.trim();
        var category = this.articleForm.get('category').value.trim();
        if (this.articleIdToUpdate === null) {
            //Handle create article
            var article = new article_1.Article(null, title, category);
            this.articleService.createArticle(article)
                .subscribe(function (successCode) {
                _this.statusCode = successCode;
                _this.getAllArticles();
                _this.backToCreateArticle();
            }, function (errorCode) { return _this.statusCode = errorCode; });
        }
        else {
            //Handle update article
            var article = new article_1.Article(this.articleIdToUpdate, title, category);
            this.articleService.updateArticle(article)
                .subscribe(function (successCode) {
                _this.statusCode = successCode;
                _this.getAllArticles();
                _this.backToCreateArticle();
            }, function (errorCode) { return _this.statusCode = errorCode; });
        }
    };
    //Load article by id to edit
    ArticleComponent.prototype.loadArticleToEdit = function (articleId) {
        var _this = this;
        this.preProcessConfigurations();
        this.articleService.getArticleById(articleId)
            .subscribe(function (article) {
            _this.articleIdToUpdate = article.id;
            _this.articleForm.setValue({ title: article.title, category: article.category });
            _this.processValidation = true;
            _this.requestProcessing = false;
        }, function (errorCode) { return _this.statusCode = errorCode; });
    };
    //Delete article
    ArticleComponent.prototype.deleteArticle = function (articleId) {
        var _this = this;
        this.preProcessConfigurations();
        this.articleService.deleteArticleById(articleId)
            .subscribe(function (successCode) {
            _this.statusCode = successCode;
            _this.getAllArticles();
            _this.backToCreateArticle();
        }, function (errorCode) { return _this.statusCode = errorCode; });
    };
    //Perform preliminary processing configurations
    ArticleComponent.prototype.preProcessConfigurations = function () {
        this.statusCode = null;
        this.requestProcessing = true;
    };
    //Go back from update to create
    ArticleComponent.prototype.backToCreateArticle = function () {
        this.articleIdToUpdate = null;
        this.articleForm.reset();
        this.processValidation = false;
    };
    return ArticleComponent;
}());
ArticleComponent = __decorate([
    core_1.Component({
        selector: 'app-article',
        templateUrl: './article.component.html',
        styleUrls: ['./article.component.css']
    }),
    __metadata("design:paramtypes", [article_service_1.ArticleService])
], ArticleComponent);
exports.ArticleComponent = ArticleComponent;
//# sourceMappingURL=article.component.js.map