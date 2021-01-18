import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './Component/header/header.component';
import { ApidemoComponent } from './apidemo/apidemo.component';
import { CalculatorComponent } from './Component/calculator/calculator.component';
import { FormComponent } from './Component/form/form.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { routerModule } from './router.module';
import { HttpClientModule } from '@angular/common/http';
import {CustomDatePipe} from './Custom_pipe/custom_date.pipe';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    ApidemoComponent,
    CalculatorComponent,
    FormComponent,
    CustomDatePipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    routerModule,
    HttpClientModule
  ],
  providers: [CustomDatePipe],
  bootstrap: [AppComponent]
})
export class AppModule { }
