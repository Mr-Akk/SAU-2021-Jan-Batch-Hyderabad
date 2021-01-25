import React, { Component } from "react";
import axios from "axios";
import StudentrowCompo from "./StudentrowCompo/StudentrowCompo";

export default class StudentdetailComponent extends Component {
  state = {
    details: [],
  };
  componentDidMount() {
    axios.get("https://api.github.com/users/hadley/orgs").then((res) => {
      this.setState({
        details: res.data,
      });
    });
  }
  onDeleteRow = (id) => {
    let newArr = this.state.details.filter((i) => i.id !== id);
    this.setState({
      details: newArr,
    });
  };
  render() {
    let data = (
      <div className="container">
        <h2>No records found!!!!</h2>
      </div>
    );
    if (this.state.details.length > 0) {
      data = (
        <div className="container">
          <table className="table ">
            <thead>
              <tr>
                <th>Id</th>
                <th>Login</th>
                <th>Avatar</th>
              </tr>
            </thead>

            <tbody>
              {this.state.details.map((i) => {
                return (
                  <StudentrowCompo
                    key={i.id}
                    detail={i}
                    del={this.onDeleteRow}
                  />
                );
              })}
            </tbody>
          </table>
        </div>
      );
    }
    return data;
  }
}
