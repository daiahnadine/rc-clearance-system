import React from "react";
import homeIcon from '../assets/homeIcon.svg';
import requestIcon from '../assets/Trello.svg';
import userIcon from '../assets/User.svg';
import rcLogo from '../assets/rc_logo.png';
import adminAvatar from '../assets/adminAvatar.svg';
import dateIcon from '../assets/Date.svg';
import '../styles/AdminDashboard.css';

const AdminDashboard = () => {
    return(
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
                <img src={adminAvatar} alt="Avatar"/>
            </div>

            <div className="academic-year-header">
                <h2>A.Y. 2024 - 2025 - First Semester</h2>
                <img src={dateIcon} alt="date icon" />
                <h4>Thursday, July 25, 2024 1:33:15</h4>
            </div>

            <div className="clearance-status">
                <h1>Account Status</h1>
            </div>

            <div className="cleared-header">
                <h4>Student Accounts</h4>
                <h3>0</h3>
            </div>

            <div className="pending-header">
                <h4>Department Accounts</h4>
                <h3>0</h3>
            </div>
        </div>
    );
};

export default AdminDashboard;