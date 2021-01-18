import {Pipe , PipeTransform} from '@angular/core';

const data = {
  '01' : 'JAN',
  '02' : 'FEB',
  '03' : 'MAR',
  '04' : 'APR',
  '05' : 'MAY',
  '06' : 'JUNE',
  '07' : 'JULY',
  '08' : 'AUG',
  '09' : 'SEPT',
  '10' : 'OCT',
  '11' : 'NOV',
  '12' : 'DEC'
}
@Pipe({
  name:"CustomDatePipe"
})
export class CustomDatePipe implements PipeTransform{
  transform(value: any, ...args: any[]) {
        let splitList = value.split("-");
        let result = data[splitList[1]] + " " + splitList[0] + " , " + splitList[2];
        return result;

  }

}
