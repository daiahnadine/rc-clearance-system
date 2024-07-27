import React from "react";
import homeIcon from '../assets/homeIcon.svg';
import requestIcon from '../assets/Trello.svg';
import rcLogo from '../assets/rc_logo.png';
import sscIcon from '../assets/sscIcon.svg';
import dateIcon from '../assets/Date.svg';
import avatar from '../assets/User.svg';
import printIcon from '../assets/printIcon.svg';
import '../styles/StudentClearanceStatus.css';

const StudentClearanceStatus = () => {
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
                    <a href="#">Clearance Request</a>
                </div>
                <div className="dashboard-buttons">
                    <img src={requestIcon} alt="Request Icon" />
                    <a href="#">Clearance Status</a>
                </div>
                <div className="dashboard-buttons">
                    <img src={avatar} alt="avatar" />
                    <a href="#">Account</a>
                </div>
            </div>

            <div className="header">
                <h4>Supreme Student Council</h4>
                <h4>SSC</h4>
                <img src={sscIcon} alt="Avatar" />
            </div>

            <div className="academic-year-header">
                <h2>A.Y. 2024 - 2025 - First Semester</h2>
                <img src={dateIcon} alt="date icon" />
                <h4>Thursday, July 25, 2024 1:33:15</h4>
            </div>

            <div className="filter-container">
            <div className="input-box">
                <select className="filter-button" defaultValue="" id="statusFilter">
                    <option value="" disabled>Filter Type</option>
                    <option value="cleared">Cleared</option>
                    <option value="pending">Pending</option>
                </select>
            </div>
            </div>

    
            <div className="table-container">
                <table className="clearance-table">
                    <thead>
                        <tr>
                            <th>Department</th>
                            <th>Status</th>
                            <th>Remarks</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Supreme Student Council</td>
                            <td>Cleared</td>
                            <td>None</td>
                        </tr>
                        <tr>
                            <td>Student Affairs</td>
                            <td>Cleared</td>
                            <td>None</td>
                        </tr>
                        <tr>
                            <td>Spiritual Affairs</td>
                            <td>Cleared</td>
                            <td>None</td>
                        </tr>
                        <tr>
                            <td>Student Discipline</td>
                            <td>Pending</td>
                            <td>None</td>
                        </tr>
                        <tr>
                            <td>Guidance</td>
                            <td>Pending</td>
                            <td>None</td>
                        </tr>
                        <tr>
                            <td>Library</td>
                            <td>Cleared</td>
                            <td>None</td>
                        </tr>
                        <tr>
                            <td>Laboratory</td>
                            <td>Pending</td>
                            <td>None</td>
                        </tr>
                        <tr>
                            <td>Clinic</td>
                            <td>Cleared</td>
                            <td>None</td>
                        </tr>
                        <tr>
                            <td>Cashier</td>
                            <td>Pending</td>
                            <td>None</td>
                        </tr>
                        <tr>
                            <td>Adviser</td>
                            <td>Cleared</td>
                            <td>None</td>
                        </tr>
                        <tr>
                            <td>Cluster Coordinator</td>
                            <td>Cleared</td>
                            <td>None</td>
                        </tr>
                        <tr>
                            <td>Registrar's Office</td>
                            <td>Cleared</td>
                            <td>None</td>
                        </tr>
                        <tr>
                            <td>Dean/TED - Director</td>
                            <td>Cleared</td>
                            <td>None</td>
                        </tr>
                    </tbody>
                </table>

                <div className="print-buttons">
                <img src={printIcon} alt="Print Icon" />
                <a href="#">Print Clearance</a>
                </div>
                </div>
            </div>
    );
};

export default StudentClearanceStatus;
