import React from "react";
import { BrowserRouter as Router, Route, Routes, Navigate } from "react-router-dom";
import Login from "./pages/Login";
import CreateAccount from "./pages/CreateAccount";
import StudentDashboard from "./pages/StudentDashboard";
import RequestClearance from "./pages/RequestClearance";
import StudentClearanceStatus from "./pages/StudentClearanceStatus";



const App = () => {
  return (
      <Router>
          <Routes>
              <Route path="/" element={<Login />} />
              <Route path="/create-account" element={<CreateAccount/>} />
              <Route path="/student-dashboard" element={<StudentDashboard/>} />
              <Route path="/request-clearance" element={<RequestClearance/>} />
              <Route path="/student-clearance-status" element={<StudentClearanceStatus/>} />
          </Routes>
      </Router>
  );
};

export default App;
