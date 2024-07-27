import React from "react";
import homeIcon from '../assets/homeIcon.svg';
import requestIcon from '../assets/Trello.svg';
import userIcon from '../assets/User.svg';
import rcLogo from '../assets/rc_logo.png';
import avatar from '../assets/Avatar.svg';
import dateIcon from '../assets/Date.svg';
import '../styles/RequestClearance.css';

const RequestClearance = () => {
    return(
        <div className="student-dashboard">
            <div className="Dashboard">
                <img src={rcLogo} alt="RC LOGO" />
                <h3>ROGATIONIST COLLEGE CLEARANCE SYSTEM</h3>
                <div className="dashboard-buttons">
                <img srca={homeIcon} alt="Home" />
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
                <img src={userIcon} alt="User Icon" />
                <a href="#">Account</a>
                </div>
            </div>

            <div className="header">
                <h4>Student</h4>
                <h4>Aiah Nadine Quinones Delos Reyes</h4>
                <img src={avatar} alt="Avatar"/>
            </div>

            <div className="academic-year-header">
                <h2>A.Y. 2024 - 2025 - First Semester</h2>
                <img src={dateIcon} alt="date icon" />
                <h4>Thursday, July 25, 2024 1:33:15</h4>
            </div>

            <div className="request-clearance-container">
                <h1>Reqauest Clearance</h1>
                <div className="dropdown-container">
                    <label htmlFor="semester">Semester</label>
                    <select className="filter-button" defaultValue="Filter Type">
                        <option disabled>Semester</option>
                        <option>First Semester</option>
                        <option>Second Semester</option>
                    </select>
                </div>
                <div className="dropdown-container">
                    <label htmlFor="schoolYear">School Year</label>
                    <select className="filter-button" defaultValue="Filter Type">
                        <option disabled>School Year</option>
                        <option>2024</option>
                        <option>2025</option>
                        <option>2026</option>
                        <option>2027</option>
                    </select>
                </div>
                <div className="dropdown-container">
                    <label htmlFor="graduating">Graduating</label>
                    <select className="filter-button" defaultValue="Filter Type">
                        <option disabled>Graduating</option>
                        <option>Yes</option>
                        <option>No</option>
                    </select>
                </div>
                <button type="submit">Request</button>
            </div>
        </div>
    );
};

export default RequestClearance;