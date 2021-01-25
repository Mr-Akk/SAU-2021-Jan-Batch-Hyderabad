import React from "react";

const StudentrowCompo = (props) => {
  let { id, login, avatar_url } = props.detail;
  let { del } = props;

  return (
    <tr>
      <td>{id}</td>
      <td>{login}</td>
      <td>
        <img
          style={{
            width: "50px",
          }}
          className="img-thumbnail rounded mx-auto"
          src={avatar_url}
          alt="hi"
        />
      </td>
      <td>
        <button className="btn btn-danger btn-sm" onClick={() => del(id)}>
          X
        </button>
      </td>
    </tr>
  );
};

export default StudentrowCompo;
