
import { NgModule } from "@angular/core";
import { RouterModule, Routes } from '@angular/router';
import { ApidemoComponent } from "./apidemo/apidemo.component";
import { CalculatorComponent } from "./Component/calculator/calculator.component";
import { FormComponent } from "./Component/form/form.component";

const arr:Routes = [
  {path:'',component:FormComponent},
  { path: 'form', component: FormComponent },
  {path : 'calculator' , component:CalculatorComponent},
  {path : 'apidemo' , component : ApidemoComponent}
]
@NgModule({
  imports:[
      RouterModule.forRoot(arr)
  ],
  exports : [RouterModule]
})
export class routerModule{

}
