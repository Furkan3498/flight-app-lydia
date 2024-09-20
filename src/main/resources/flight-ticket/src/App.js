import React, { useState, useEffect } from 'react';
import { BrowserRouter as Router, Route, Routes, Navigate } from 'react-router-dom';
import axios from 'axios';
import LoginPage from './LoginPage';
import RegisterPage from './RegisterPage';
import AdminPanel from "./FlightTicket";
import Header from "./Header";

const App = () => {
    const [auth, setAuth] = useState(false);
    const [user, setUser] = useState(null);  // Add user state
    const [registered, setRegistered] = useState(false);  // Add registered state



    // Handle logout
    const handleLogout = () => {
        localStorage.removeItem('token');
        localStorage.removeItem('user');
        setAuth(false);
        setUser(null);
    };

    // Check for token on mount
    useEffect(() => {
        const token = localStorage.getItem('token');
        const storedUser = localStorage.getItem('user'); // Check if user info is stored

        if (token) {
            axios.defaults.headers.common['Authorization'] = `Bearer ${token}`; // Set token in headers
            setAuth(true); // Set auth to true
            if (storedUser) {
                setUser(JSON.parse(storedUser)); // Set user from local storage
            }
        }
    }, []);

    return (
        <Router>
            {auth && <Header user={user} onLogout={handleLogout} />} {/* Show header when authenticated */}
            <Routes>
                {/* Login Route */}
                <Route
                    path="/login"
                    element={!auth ? <LoginPage setAuth={setAuth} setUser={setUser} /> : <Navigate to="/admin" replace={true} />}
                />

                {/* Register Route */}
                <Route
                    path="/register"
                    element={registered ? <Navigate to="/login" replace={true} /> : <RegisterPage setRegistered={setRegistered} />}
                />

                {/* Admin Panel Route */}
                <Route
                    path="/admin"
                    element={auth ? <AdminPanel /> : <Navigate to="/login" replace={true} />}
                />

                {/* Fallback Route */}
                <Route
                    path="*"
                    element={<Navigate to="/login" replace={true} />}
                />
            </Routes>
        </Router>
    );
};


export default App;
