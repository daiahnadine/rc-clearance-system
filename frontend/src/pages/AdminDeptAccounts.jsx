import React, { useEffect, useState } from "react";
import axios from "axios";
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
    const [advisers, setAdvisers] = useState([]);
    const [cashiers, setCashiers] = useState([]);
    const [clinics, setClinics] = useState([]);
    const [clusterCoordinators, setClusterCoordinators] = useState([]);
    const [deans, setDeans] = useState([]);
    const [guidances, setGuidances] = useState([]);
    const [laboratories, setLaboratories] = useState([]);
    const [libraries, setLibraries] = useState([]);
    const [registrars, setRegistrars] = useState([]);
    const [spiritualAffairs, setSpiritualAffairs] = useState([]);
    const [studentAffairs, setStudentAffairs] = useState([]);
    const [studentDisciplines, setStudentDisciplines] = useState([]);
    const [supremeStudentCouncils, setSupremeStudentCouncils] = useState([]);
    const [currentDateTime, setCurrentDateTime] = useState(new Date());

    const apiUrl = "http://localhost:8080/Dashboard/accounts";

    useEffect(() => {
        axios.get(apiUrl)
            .then(response => {
                const {
                    advisers,
                    cashiers,
                    clinics,
                    clusterCoordinators,
                    deans,
                    guidances,
                    laboratories,
                    libraries,
                    registrars,
                    spiritualAffairs,
                    studentAffairs,
                    studentDisciplines,
                    supremeStudentCouncils
                } = response.data;

                setAdvisers(advisers);
                setCashiers(cashiers);
                setClinics(clinics);
                setClusterCoordinators(clusterCoordinators);
                setDeans(deans);
                setGuidances(guidances);
                setLaboratories(laboratories);
                setLibraries(libraries);
                setRegistrars(registrars);
                setSpiritualAffairs(spiritualAffairs);
                setStudentAffairs(studentAffairs);
                setStudentDisciplines(studentDisciplines);
                setSupremeStudentCouncils(supremeStudentCouncils);
            })
            .catch(error => {
                console.error("There was an error fetching the data!", error);
            });

        const updateDateTime = () => {
            setCurrentDateTime(new Date());
        };

        const intervalId = setInterval(updateDateTime, 1000);

        return () => clearInterval(intervalId);

    }, []);

    const getDepartmentName = (entity) => {
        return entity.department ? entity.department.name : "N/A";
    };

    const getType = (entity) => {
        if (advisers.includes(entity)) return "Adviser";
        if (cashiers.includes(entity)) return "Cashier";
        if (clinics.includes(entity)) return "Clinic";
        if (clusterCoordinators.includes(entity)) return "Cluster Coordinator";
        if (deans.includes(entity)) return "Dean";
        if (guidances.includes(entity)) return "Guidance";
        if (laboratories.includes(entity)) return "Laboratory";
        if (libraries.includes(entity)) return "Library";
        if (registrars.includes(entity)) return "Registrar";
        if (spiritualAffairs.includes(entity)) return "Spiritual Affairs";
        if (studentAffairs.includes(entity)) return "Student Affairs";
        if (studentDisciplines.includes(entity)) return "Student Discipline";
        if (supremeStudentCouncils.includes(entity)) return "Supreme Student Council";
        return "Unknown";
    };

    const allDepartments = [
        ...advisers,
        ...cashiers,
        ...clinics,
        ...clusterCoordinators,
        ...deans,
        ...guidances,
        ...laboratories,
        ...libraries,
        ...registrars,
        ...spiritualAffairs,
        ...studentAffairs,
        ...studentDisciplines,
        ...supremeStudentCouncils
    ];

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
                <h4>{currentDateTime.toLocaleString()}</h4>
            </div>

            <div className="filter-container">
                <div className="input-box">
                    <input type="text" id="searchInput" className="search-input" placeholder="Search by name"/>
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

            <div className="clearance-status">
                <h1>Department Accounts</h1>
            </div>

            <table className="clearance-table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Department</th>
                        <th>Name</th>
                        <th>Employee Number</th>
                        <th>Address</th>
                        <th>Contact Number</th>
                        <th>Email</th>
                        <th>Civil Status</th>
                        <th>Birthday</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {allDepartments.map(person => (
                        <tr key={person.id}>
                            <td>{person.id}</td>
                            <td>{getType(person)}</td>
                            <td>{person.firstName} {person.middleName} {person.lastName}</td>
                            <td>{person.employeeNumber}{person.deanNumber} {person.supremeStudentCouncilNumber}</td>
                            <td>{person.address || "N/A"}</td>
                            <td>{person.contactNumber || "N/A"}</td>
                            <td>{person.email || "N/A"}</td>
                            <td>{person.civilStatus || "N/A"}</td>
                            <td>{person.birthdate ? new Date(person.birthdate).toLocaleDateString() : "N/A"}</td>
                            <td className="status-cell">
                                <img src={edit} alt="edit" />
                                <img src={deleteIcon} alt="delete" />
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};

export default AdminDashboard;
