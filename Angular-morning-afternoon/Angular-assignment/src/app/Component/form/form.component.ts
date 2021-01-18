import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup , Validators} from '@angular/forms'

import * as loadash from 'lodash';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {

  count:number = 1;
  id:number;
  firstname:string ;
  lastname:string;
  email:string;
  phonenumber:string;

  isAsc:Boolean = true;
  list_of_details  = [];
  constructor() { }

  ngOnInit(): void {

    if(sessionStorage.getItem('userDetails')){


      this.list_of_details = JSON.parse(sessionStorage.getItem('userDetails'));
        console.log(this.list_of_details);
}
    else{
      console.log("no datas available in session storage");

    }

  }
emailRegEx = /^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$/
  form = new FormGroup({
    firstName: new FormControl('',[Validators.required]),
    lastName: new FormControl('',[Validators.required]),
    email : new FormControl('',[Validators.required , Validators.pattern(this.emailRegEx)]),
    phonenumber : new FormControl('',[Validators.required])
  });


  check = (event)=>{
        let sort_by = event.target.id
        let newList:any = '';
        if(this.isAsc){
          newList = loadash.orderBy(this.list_of_details,[`${sort_by}`],['asc']);
      }else{
          newList = loadash.orderBy(this.list_of_details,[`${sort_by}`],['desc']);
          }
         this.list_of_details = newList;

 }

  onSubmit = ()=>{
        if (this.form.valid){
          this.firstname= this.form.controls.firstName.value;
        this.lastname = this.form.controls.lastName.value;
       this.email = this.form.controls.email.value;
        this.phonenumber= this.form.controls.phonenumber.value
        let userDetails = {
          id : this.count++,
          firstName : this.firstname,
          lastName : this.lastname,
          email :this.email ,
          phonenumber : this.phonenumber,
        }
        this.list_of_details.push(userDetails);
        sessionStorage.setItem('userDetails' , JSON.stringify(this.list_of_details));
        this.form.reset();
      }else{
        alert("Enter the right credentials and try again!")
      }
  }

  onOrderChange = (event) =>{

    event.target.value === 'asc' ? this.isAsc = true : this.isAsc = false;
  }

  onDelete = (id) =>{
        console.log(id);

        let newList = this.list_of_details.filter( i => i.id!==id);

        this.list_of_details = newList;
        sessionStorage.setItem('userDetails' , JSON.stringify(this.list_of_details));


  }

}
