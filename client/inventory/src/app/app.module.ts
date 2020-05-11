import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { NgxPaginationModule } from 'ngx-pagination';
import { OrderModule } from 'ngx-order-pipe';
import { AppRoutingModule } from './app.routes';
import { AppComponent } from './app.component';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { LoginComponent } from './login/login.component';
import { HomeadminComponent } from './homeadmin/homeadmin.component';
import { HomeuserComponent } from './homeuser/homeuser.component';
import { CategoryComponent } from './category/category.component';
import { FilterPipe } from './filter/filter.pipe';
@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeadminComponent,
    HomeuserComponent,
        CategoryComponent,
        FilterPipe
  ],
    imports: [
        NgbModule,
    BrowserModule,
    AppRoutingModule,
      HttpClientModule,
      ReactiveFormsModule,
        FormsModule,
        NgxPaginationModule,
        OrderModule,
     
   

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
