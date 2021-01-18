import { CalculatorServiceService } from '../../services/calculatorservice/calculator.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {

 date_today = '18-01-2021';

  result:any = '';
   num1 : number;
  num2:number;
  isDisabled:Boolean = true;
  constructor(private calculator:CalculatorServiceService){

  }
  ngOnInit(){

  }

        onClickAdd = ()=>{

             this.result = this.calculator.onClickAdd(this.num1,this.num2);
             this.isDisabled = false;
        }
          onClickSub = ()=>{
        this.result = this.calculator.onClickSub(this.num1,this.num2);
        this.isDisabled = false;
        }
          onClickMult = ()=>{
        this.result = this.calculator.onClickMult(this.num1,this.num2);
        this.isDisabled = false;
        }
          onClickDiv = ()=>{
        this.result = this.calculator.onClickDiv(this.num1,this.num2).toFixed(2);

        this.isDisabled = false;
        }


}
