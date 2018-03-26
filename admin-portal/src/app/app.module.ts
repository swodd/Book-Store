import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatButtonModule, MatCheckboxModule} from '@angular/material';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatInputModule} from '@angular/material/input';
import {MatSelectModule} from '@angular/material/select';
import {MatSlideToggleModule} from '@angular/material/slide-toggle';



import 'hammerjs';

import { routing } from './app.routing';
import { AppComponent } from './app.component';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import { LoginComponent } from './components/login/login.component';

import { LoginService } from './services/login.service';
import { AddBookService } from './services/add-book.service';
import { UploadImageService } from './services/upload-image.service';
import { GetBookListService } from './services/get-book-list.service';
import { AddNewBookComponent } from './components/add-new-book/add-new-book.component';
import { BookListComponent } from './components/book-list/book-list.component';


@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    LoginComponent,
    AddNewBookComponent,
    BookListComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCheckboxModule,
    MatToolbarModule,
    MatGridListModule,
    MatInputModule,
    MatSelectModule,
    MatSlideToggleModule,
    routing
  ],
  providers: [
    LoginService,
    AddBookService,
    UploadImageService,
    GetBookListService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
