import React, { useEffect, useState } from "react";
import axios from "axios";
import homeIcon from "../assets/homeIcon.svg";
import requestIcon from "../assets/Trello.svg";
import userIcon from "../assets/User.svg";
import rcLogo from "../assets/rc_logo.png";
import adminAvatar from "../assets/adminAvatar.svg";
import dateIcon from "../assets/Date.svg";
import edit from "../assets/Edit (1).svg";
import deleteIcon from "../assets/delete.svg";
import "../styles/AdminStudentAccounts.css";

const AdminStudentAccounts = () => {
  const [students, setStudents] = useState([]);
  const apiUrlStudents = "http://localhost:8080/Student/students"; // API endpoint for students

  useEffect(() => {
    // Fetch student data from the API
    axios
      .get(apiUrlStudents)
      .then((response) => {
        setStudents(response.data);
      })
      .catch((error) => {
        console.error("There was an error fetching the student data!", error);
      });
  }, []);

  const handleEdit = (studentId) => {
    // Implement edit functionality here
    console.log(`Editing student with ID: ${studentId}`);
  };

  const handleDelete = (studentId) => {
    // Implement delete functionality here
    console.log(`Deleting student with ID: ${studentId}`);
  };

  return (
    <div className="student-dashboard">
      <div className="Dashboard">
        <img src={rcLogo} alt="RC LOGO" />
        <h3>ROGATIONIST COLLEGE CLEARANCE SYSTEM</h3>
        <div className="dashboard-buttons">
          <img src={homeIcon} alt="Home" />
          <a href="#">Dashboard</a>
        </div>
        <div className="dashboard-buttons">
          <img src={requestIcon} alt="Request Icon" />
          <a href="#">Department</a>
        </div>
        <div className="dashboard-buttons">
          <img src={userIcon} alt="User Icon" />
          <a href="#">Students</a>
        </div>
      </div>

      <div className="header">
        <h4>Administrator</h4>
        <h4>Admin</h4>
        <img src={adminAvatar} alt="Avatar" />
      </div>

      <div className="academic-year-header">
        <h2>A.Y. 2024 - 2025 - First Semester</h2>
        <img src={dateIcon} alt="date icon" />
        <h4>Thursday, July 25, 2024 1:33:15</h4>
      </div>

      <div className="clearance-status">
        <h1>Student Accounts</h1>
      </div>

      <table className="clearance-table">
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Student ID</th>
            <th>Course</th>
            <th>Year Level</th>
            <th>Address</th>
            <th>Contact Number</th>
            <th>Email</th>
            <th>Birthday</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {students.map((student) => (
            <tr key={student.id}>
              <td>{student.studentNumber || "N/A"}</td>
              <td>{`${student.firstName} ${student.middleName || ""} ${
                student.lastName
              }`}</td>
              <td>{student.user?.username || "N/A"}</td>
              <td>{student.course?.name || "N/A"}</td>
              <td>{student.yearLevel?.level || "N/A"}</td>
              <td>{student.address || "N/A"}</td>
              <td>{student.contactNumber || "N/A"}</td>
              <td>{student.email || "N/A"}</td>
              <td>
                {student.birthdate
                  ? new Date(student.birthdate).toLocaleDateString()
                  : "N/A"}
              </td>
              <td className="status-cell">
                <img
                  src={edit}
                  alt="edit"
                  onClick={() => handleEdit(student.id)}
                  style={{ cursor: "pointer" }}
                />
                <img
                  src={deleteIcon}
                  alt="delete"
                  onClick={() => handleDelete(student.id)}
                  style={{ cursor: "pointer" }}
                />
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default AdminStudentAccounts;
