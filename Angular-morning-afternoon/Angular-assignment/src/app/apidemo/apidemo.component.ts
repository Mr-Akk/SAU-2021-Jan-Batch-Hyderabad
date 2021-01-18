import { ApiService } from './../services/APIservice/api.service';
import { Component, OnInit } from '@angular/core';
import { UserDetail } from '../Schemas/UserDetail';

@Component({
  selector: 'app-apidemo',
  templateUrl: './apidemo.component.html',
  styleUrls: ['./apidemo.component.css']
})
export class ApidemoComponent implements OnInit {

   userArr:{id:number ,
  name:string,
    email:string,
    phonenumber:string}[] = [];

  constructor(private apiService : ApiService) { }

  ngOnInit(): void {
  }

  onGetData(){

    this.apiService.getData().subscribe( (res:UserDetail[]) =>{

      res.forEach(i=>{

        let userValue = {
          id : i.id,
          name:i.name,
          email:i.email,
          phonenumber:i.phone
        }

    this.userArr.push(userValue);
})

})

  }

}
