import React from "react";
import homeIcon from '../assets/homeIcon.svg';
import requestIcon from '../assets/Trello.svg';
import userIcon from '../assets/User.svg';
import rcLogo from '../assets/rc_logo.png';
import avatar from '../assets/Avatar.svg';
import Edit from '../assets/Edit.svg';
import '../styles/StudentAccount.css';

const StudentAccount = () => {
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

            <div className="my-profile">
                <h1>My Profile</h1>
            </div>

            <div className="first-name">
                <h4>First Name</h4>
                <img src={Edit} alt="Edit Icon" />
                <h3>Aiah Nadine</h3>
            </div>

            <div className="middle-name">
                <h4>Middle Name</h4>
                <img src={Edit} alt="Edit Icon" />
                <h3>Quiñones</h3>
            </div>

            <div className="last-name">
                <h4>Last Name</h4>
                <img src={Edit} alt="Edit Icon" />
                <h3>Delos Reyes</h3>
            </div>

            <div className="student-id">
                <h4>Student ID</h4>
                <h3>CT21-0099</h3>
            </div>

            <div className="contact-number">
                <h4>Contact Number</h4>
                <img src={Edit} alt="Edit Icon" />
                <h3>09923692695</h3>
            </div>

            <div className="email-address">
                <h4>Email Address</h4>
                <img src={Edit} alt="Edit Icon" />
                <h3>aiahnadinedelosreyes@gmail.com</h3>
            </div>

            <div className="year-level">
                <h4>Year Level</h4>
                <img src={Edit} alt="Edit Icon" />
                <h3>Fourth Year</h3>
            </div>

            <div className="course">
                <h4>Course</h4>
                <img src={Edit} alt="Edit Icon" />
                <h3>Information Technology</h3>
            </div>
        </div>
    );
};

export default StudentAccount;