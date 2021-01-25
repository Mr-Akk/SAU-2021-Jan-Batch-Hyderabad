import React, { useState } from "react";

const Bottle = () => {
  const [name, setname] = useState("hi");
  const [num1, setnum1] = useState(0);
  const [num2, setnum2] = useState(0);

  let onChangeBootlename = (val) => {
    setname(val);
  };

  return (
    <div>
      <button
        onClick={() => {
          setname("akash");
        }}
      >
        change me
      </button>
      <p>I am Bottle</p>
      <p>{name}</p>
      <h3>Type here to change the text!</h3>
      <input
        type="text"
        onChange={(event) => {
          onChangeBootlename(event.target.value);
        }}
      />
      <h3>Add two numbers</h3>
      <input type="number" onChange={(event) => setnum1(event.target.value)} />
      <input type="number" onChange={(event) => setnum2(event.target.value)} />
      <button
        style={{
          padding: "3px",
          border: "2px solid black",
          fontSize: "20px",
          marginBottom: "1rem",
        }}
        onClick={() => {
          setname(+num1 + +num2);
        }}
      >
        Add
      </button>
    </div>
  );
};

export default Bottle;
