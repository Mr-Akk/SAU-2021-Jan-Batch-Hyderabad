import { CustomerComponent } from './Component/customer/customer.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProductsComponent } from './Component/products/products.component';

const routes: Routes = [
  {path:"" , component:CustomerComponent},
{path:"customer" , component:CustomerComponent},
{path:"product" , component:ProductsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
