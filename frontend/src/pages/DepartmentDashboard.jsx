import React from "react";
import homeIcon from '../assets/homeIcon.svg';
import requestIcon from '../assets/Trello.svg';
import rcLogo from '../assets/rc_logo.png';
import sscIcon from '../assets/sscIcon.svg';
import dateIcon from '../assets/Date.svg';
import '../styles/DepartmentDashboard.css';

const DepartmentDashboard = () => {
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
                <a href="#">Clearance Request</a>
                </div>
            </div>

            <div className="header">
                <h4>SSC</h4>
                <h4>Supreme Student Council</h4>
                <img src={sscIcon} alt="Avatar"/>
            </div>

            <div className="academic-year-header">
                <h2>A.Y. 2024 - 2025 - First Semester</h2>
                <img src={dateIcon} alt="date icon" />
                <h4>Thursday, July 25, 2024 1:33:15</h4>
            </div>

            <div className="clearance-status">
                <h1>Clearance Status</h1>
            </div>

            <div className="cleared-header">
                <h4>Clearance Requests</h4>
                <h3>0</h3>
            </div>

            <div className="pending-header">
                <h4>Cleared</h4>
                <h3>0</h3>
            </div>

            <div className="remarks-header">
                <h4>Pending</h4>
                <h3>0</h3>
            </div>
        </div>
    );
};

export default DepartmentDashboard;