import React from "react";
import { BrowserRouter as Router, Route, Routes, Navigate } from "react-router-dom";
import Login from "./pages/Login";
import CreateAccount from "./pages/CreateAccount";
import StudentDashboard from "./pages/StudentDashboard";
import RequestClearance from "./pages/RequestClearance";
import StudentClearanceStatus from "./pages/StudentClearanceStatus";
import StudentAccount from "./pages/StudentAccount";
import DepartmentDashboard from "./pages/DepartmentDashboard";
import DepartmentClearanceRequest from "./pages/DepartmentClearanceRequest";
import AdminDashboard from "./pages/AdminDashboard";
import AdminDeptAccounts from "./pages/AdminDeptAccounts";
import AdminStudentAccounts from "./pages/AdminStudentAccounts";



const App = () => {
  return (
      <Router>
          <Routes>
              <Route path="/" element={<Login />} />
              <Route path="/create-account" element={<CreateAccount/>} />
              <Route path="/student-dashboard" element={<StudentDashboard/>} />
              <Route path="/request-clearance" element={<RequestClearance/>} />
              <Route path="/student-clearance-status" element={<StudentClearanceStatus/>} />
              <Route path="/student-account" element={<StudentAccount/>} />
              <Route path="/department-dashboard" element={<DepartmentDashboard/>} />
              <Route path="/department-clearance-request" element={<DepartmentClearanceRequest/>} />
              <Route path="/admin-dashboard" element={<AdminDashboard/>} />
              <Route path="/admin-dept-accounts" element={<AdminDeptAccounts/>} />
              <Route path="/admin-student-accounts" element={<AdminStudentAccounts/>} />
          </Routes>
      </Router>
  );
};

export default App;
