import React from "react";
import homeIcon from '../assets/homeIcon.svg';
import requestIcon from '../assets/Trello.svg';
import userIcon from '../assets/User.svg';
import rcLogo from '../assets/rc_logo.png';
import adminAvatar from '../assets/adminAvatar.svg';
import dateIcon from '../assets/Date.svg';
import edit from '../assets/Edit (1).svg';
import deleteIcon from '../assets/delete.svg';
import '../styles/AdminDeptAccounts.css';

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

            <div className="filter-container">
                <div className="input-box">
                    <input type="text" id="searchInput" className="search-input" placeholder="Searh by name"/>
                </div>

            <div className="input-box">
                <select className="filter-button" defaultValue="" id="statusFilter">
                    <option value="" disabled>Filter Type</option>
                    <option value="ssc">SSC</option>
                    <option value="osa">Student Affairs</option>
                    <option value="spiritual-affairs">Spiritual Affairs</option>
                    <option value="prefect">Student Discipline</option>
                    <option value="guidance">Guidance</option>
                    <option value="library">Library</option>
                    <option value="laboratory">Laboratory</option>
                    <option value="clinic">Clinic</option>
                    <option value="cashier">Cashier</option>
                    <option value="adviser">Adviser</option>
                    <option value="coordinator">Cluster Coordinator</option>
                    <option value="registrar">Registrar</option>
                    <option value="dean">Dean</option>
                </select>
            </div>
            </div>
        

            <table className="clearance-table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Department</th>
                        <th>Username</th>
                        <th>Password</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>1</td>
                        <td>Supreme Student Council</td>
                        <td>ssc</td>
                        <td>password</td>
                        <td className="status-cell">
                            <img src={edit} alt="edit" />
                            <img src={deleteIcon} alt="delete" />
                        </td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>Student Affairs</td>
                        <td>osa</td>
                        <td>password</td>
                        <td className="status-cell">
                            <img src={edit} alt="edit" />
                            <img src={deleteIcon} alt="delete" />
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    );
};

export default AdminDashboard;