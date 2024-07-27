import React from "react";
import homeIcon from '../assets/homeIcon.svg';
import requestIcon from '../assets/Trello.svg';
import rcLogo from '../assets/rc_logo.png';
import sscIcon from '../assets/sscIcon.svg';
import dateIcon from '../assets/Date.svg';
import clearedtoggle from '../assets/clearedtoggle.svg';
import pendingtoggle from '../assets/pendingtoggle.svg';
import '../styles/DepartmentClearanceRequest.css';

const DepartmentClearanceRequest = () => {
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
        <input type="text" id="searchInput" className="search-input" placeholder="Search by last name" />
    </div>

    <div className="input-box">
        <select className="filter-button" defaultValue="" id="statusFilter">
            <option value="" disabled>Filter Type</option>
            <option value="cleared">Cleared</option>
            <option value="pending">Pending</option>
        </select>
    </div>

    <div className="input-box">
        <select className="filter-button" defaultValue="" id="yearLevel">
            <option value="" disabled>Year Level</option>
            <option value="first-year">First Year</option>
            <option value="second-year">Second Year</option>
            <option value="third-year">Third Year</option>
            <option value="fourth-year">Fourth Year</option>
        </select>
    </div>

    <div className="input-box">
        <select className="filter-button" defaultValue="" id="courseFilter">
            <option value="" disabled>Course</option>
            <option value="accountancy">Bachelor of Science in Accountancy</option>
            <option value="tourism-management">Bachelor of Science in Tourism Management</option>
            <option value="hospitality-management">Bachelor of Science in Hospitality Management</option>
            <option value="marketing">Bachelor of Science in Business Administration - Marketing</option>
            <option value="it">Bachelor of Science in Information Technology</option>
            <option value="industrial-technology">Bachelor of Science in Industrial Technology</option>
            <option value="electronics-engineering">Bachelor of Science in Electronics Engineering</option>
        </select>
        </div>
    </div>

        

            <div className="table-container">
                <table className="clearance-table">
                    <thead>
                        <tr>
                            <th>Student ID</th>
                            <th>Name</th>
                            <th>Year Level</th>
                            <th>Course</th>
                            <th>Status</th>
                            <th>Remarks</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>CT21-0099</td>
                            <td>Aiah Nadine Q. Delos Reyes</td>
                            <td>Fourth Year</td>
                            <td>Information Technology</td>
                            <td><img src={clearedtoggle} alt="Cleared" /></td>
                            <td>None</td>
                        </tr>
                        <tr>
                            <td>CT21-0014</td>
                            <td>Ericka Mianne D. Ferma</td>
                            <td>Fourth Year</td>
                            <td>Information Technology</td>
                            <td><img src={pendingtoggle} alt="Pending" /></td>
                            <td>None</td>
                        </tr>
                    </tbody>
                </table>
                </div>
            </div>
    );
};

export default DepartmentClearanceRequest;
