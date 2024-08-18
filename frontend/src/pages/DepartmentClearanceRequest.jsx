import React, { useState, useEffect } from "react";
import axios from "axios";
import homeIcon from '../assets/homeIcon.svg';
import requestIcon from '../assets/Trello.svg';
import rcLogo from '../assets/rc_logo.png';
import sscIcon from '../assets/sscIcon.svg';
import dateIcon from '../assets/Date.svg';
import clearedtoggle from '../assets/clearedtoggle.svg';
import pendingtoggle from '../assets/pendingtoggle.svg';
import '../styles/DepartmentClearanceRequest.css';

const DepartmentClearanceRequest = () => {
    const [clearanceRequests, setClearanceRequests] = useState([]);
    const [filteredRequests, setFilteredRequests] = useState([]);
    const [searchTerm, setSearchTerm] = useState("");
    const [statusFilter, setStatusFilter] = useState("");
    const [yearLevelFilter, setYearLevelFilter] = useState("");
    const [courseFilter, setCourseFilter] = useState("");

    const [yearLevels, setYearLevels] = useState([]);
    const [courses, setCourses] = useState([]);

    // Fetch clearance requests data
    useEffect(() => {
        axios.get("http://localhost:8080/Requests/all")
            .then(response => {
                setClearanceRequests(response.data);
                setFilteredRequests(response.data); // Initially, all requests are displayed
            })
            .catch(error => {
                console.error("Error fetching clearance requests:", error);
            });
    }, []);

    // Fetch year levels and courses data
    useEffect(() => {
        axios.get("http://localhost:8080/Year/levels")
            .then(response => {
                setYearLevels(response.data);
            })
            .catch(error => {
                console.error("Error fetching year levels:", error);
            });

        axios.get("http://localhost:8080/Course/courses")
            .then(response => {
                setCourses(response.data);
            })
            .catch(error => {
                console.error("Error fetching courses:", error);
            });
    }, []);

    // Handle search and filters
    useEffect(() => {
        let filtered = clearanceRequests;

        if (searchTerm) {
            const searchTerms = searchTerm.toLowerCase().split(/\s+/); // Split search term into parts

            filtered = filtered.filter(request => {
                const fullName = `${request.student.firstName} ${request.student.middleName || ''} ${request.student.lastName}`.toLowerCase();
                return searchTerms.every(term => fullName.includes(term));
            });
        }

        if (statusFilter) {
            filtered = filtered.filter(request => request.status.toLowerCase() === statusFilter.toLowerCase());
        }

        if (yearLevelFilter) {
            filtered = filtered.filter(request => request.student.yearLevel.yearLevel === yearLevelFilter);
        }

        if (courseFilter) {
            filtered = filtered.filter(request => request.student.course.courseName === courseFilter);
        }

        setFilteredRequests(filtered);
    }, [searchTerm, statusFilter, yearLevelFilter, courseFilter, clearanceRequests]);

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
                    <input 
                        type="text" 
                        id="searchInput" 
                        className="search-input" 
                        placeholder="Search by name" 
                        value={searchTerm}
                        onChange={e => setSearchTerm(e.target.value)}
                    />
                </div>

                <div className="input-box">
                    <select 
                        className="filter-button" 
                        defaultValue="" 
                        id="statusFilter" 
                        onChange={e => setStatusFilter(e.target.value)}
                    >
                        <option value="" disabled>Filter Type</option>
                        <option value="cleared">Cleared</option>
                        <option value="pending">Pending</option>
                    </select>
                </div>

                <div className="input-box">
                    <select 
                        className="filter-button" 
                        defaultValue="" 
                        id="yearLevel" 
                        onChange={e => setYearLevelFilter(e.target.value)}
                    >
                        <option value="" disabled>Year Level</option>
                        {yearLevels.map(level => (
                            <option key={level.yearLevelId} value={level.yearLevel}>
                                {level.yearLevel}
                            </option>
                        ))}
                    </select>
                </div>

                <div className="input-box">
                    <select 
                        className="filter-button" 
                        defaultValue="" 
                        id="courseFilter" 
                        onChange={e => setCourseFilter(e.target.value)}
                    >
                        <option value="" disabled>Course</option>
                        {courses.map(course => (
                            <option key={course.courseId} value={course.courseName}>
                                {course.courseName}
                            </option>
                        ))}
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
                        {filteredRequests.length > 0 ? (
                            filteredRequests.map(request => (
                                <tr key={request.id}>
                                    <td>{request.student.studentNumber}</td>
                                    <td>{`${request.student.firstName} ${request.student.middleName || ''} ${request.student.lastName}`}</td>
                                    <td>{request.student.yearLevel.yearLevel}</td>
                                    <td>{request.student.course.courseName}</td>
                                    <td>
                                        <img 
                                            src={request.status.toLowerCase() === "cleared" ? clearedtoggle : pendingtoggle} 
                                            alt={request.status} 
                                        />
                                    </td>
                                    <td>{request.remarks || "None"}</td>
                                </tr>
                            ))
                        ) : (
                            <tr>
                                <td colSpan="6">No clearance requests found.</td>
                            </tr>
                        )}
                    </tbody>
                </table>
            </div>
        </div>
    );
};

export default DepartmentClearanceRequest;
