import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  constructor(private httpClient:HttpClient) { }

  products:any = [];
  ngOnInit(): void {

  }

  onGetProducts(){
 this.httpClient.get("/product/get/all").subscribe(
      res =>{
        this.products = res;
      }
    )
  }

    onAddProduct(productFrom){
      let {value} = productFrom;
          this.httpClient.post("/product/add" , value , {responseType : 'text'})
          .subscribe( res =>{
            console.log(res);
            productFrom.reset()
            alert("prodtct added Successfully!!!")
          })

    }

  }
