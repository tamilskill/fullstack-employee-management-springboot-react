import { useEffect, useState } from "react";
import "./App.css";
import axios from "axios";

const employeeDetails = [
  {
    id: 3,
    name: "Tamil",
    department: "cse",
  },
  {
    id: 4,
    name: "Skillhub",
    department: "cse",
  },
  {
    id: 5,
    name: "Skillhub",
    department: "cse",
  },
  {
    id: 6,
    name: "Skillhub",
    department: "cse",
  },
  {
    id: 7,
    name: "Skillhub",
    department: "cse",
  },
  {
    id: 8,
    name: "Skillhub",
    department: "cse",
  },
];

function App() {
  const [state, setState] = useState(null);

  useEffect(() => {
    axios
      .get("http://localhost:8080/api/employees")
      .then((res) => setState(res.data));
  }, []);

  const addemployee = () => {
    axios
      .post("http://localhost:8080/api/employee", {
        name: "Skillhub",
        department: "it",
      })
      .then((res) => console.log(res))
      .catch((err) => console.log(err));
  };

  const updateEmployee = () => {
    const employeeid = 3;
    axios
      .put(`http://localhost:8080/api/employee/${employeeid}`, { name: "Tam" })
      .then((res) => console.log(res));
  };

  const deleteEmployee = () => {
    const employeeid = 9;
    axios
      .delete(`http://localhost:8080/api/employee/${employeeid}`, {
        name: "Tam",
      })
      .then((res) => console.log(res));
  };

  return (
    <div className="App">
      <h1>Employee List</h1>
      {state?.map((employee) => (
        <li>{employee.name}</li>
      ))}
      <button onClick={addemployee}>Add employee</button>
      <button onClick={updateEmployee}>Update Employee</button>
      <button onClick={deleteEmployee}>Delete employee</button>
    </div>
  );
}

export default App;
