import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CalculatorServiceService {

  constructor() {

  }

  onClickAdd = (num1:number , num2:number)=>{
   return num1+num2;
}

onClickSub = (num1:number , num2:number)=>{
 return num1-num2;
}
  onClickMult = (num1:number , num2:number)=>{
return num1*num2;
}
  onClickDiv = (num1:number , num2:number)=>{
 return num1/num2;
}
}
