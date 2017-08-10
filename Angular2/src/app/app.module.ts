import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent }  from './app.component';
import { OldAppComponent }  from './old//app.component.old';
import { OldSubComponent }  from './old/sub.component.old';
import { ArticleComponent }  from './article/article.component';
import { ReactiveFormsModule } from '@angular/forms';
import { ArticleService } from './article/article.service';
import { HttpModule } from '@angular/http';
import { Appproduct }  from './product.component';
import { AppInventory }  from './Inventory.component';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { ProductFormComponent } from './product-form.component';


const appRoutes: Routes = [
   { path: 'Product', component: Appproduct },
   { path: 'Inventory', component: AppInventory },
];


@NgModule({
  imports:      [ BrowserModule, RouterModule.forRoot(appRoutes) , HttpModule, FormsModule, ReactiveFormsModule ],
  providers: [ArticleService],
  declarations: [ AppComponent,Appproduct,AppInventory, ProductFormComponent, OldAppComponent ,ArticleComponent],
  bootstrap:    [ AppComponent ],
  exports: [OldAppComponent]
})



export class AppModule { }
