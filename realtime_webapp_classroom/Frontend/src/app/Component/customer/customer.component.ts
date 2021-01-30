import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {

  constructor(private httpClient:HttpClient) { }

  ngOnInit(): void {
  }

  onSubmit(value ){
        console.log(value);
        this.httpClient.post("/customer/add" , value , {responseType : 'text'})
        .subscribe(res=>{
          console.log(res);
          alert("Customer created successfully!!!!")
        })
}
}
