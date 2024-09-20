import React, { useState } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';
import './LoginPage.css'; // Import CSS for styling

const LoginPage = ({ setAuth, setUser }) => {
    const [credentials, setCredentials] = useState({
        username: '',
        password: ''
    });

    const [error, setError] = useState('');

    // Handle form input changes
    const handleChange = (e) => {
        const { name, value } = e.target;
        setCredentials({
            ...credentials,
            [name]: value
        });
    };

    // Handle form submission
    const handleSubmit = (e) => {
        e.preventDefault();
        axios.post('http://localhost:8080/authenticate', credentials)
            .then(response => {
                const token = response.data; // Handle the token directly since the response has only token
                if (token) {
                    localStorage.setItem('token', token);  // Save token to localStorage
                    axios.defaults.headers.common['Authorization'] = `Bearer ${token}`; // Set token in axios header
                    setAuth(true);
                } else {
                    setError('Login failed: Invalid response from server.');
                }
            })
            .catch(error => {
                setError('Invalid username or password');
            });
    };


    return (
        <div className="login-container">
            <h2>Login</h2>
            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    name="username"
                    placeholder="Username"
                    value={credentials.username}
                    onChange={handleChange}
                    required
                />
                <input
                    type="password"
                    name="password"
                    placeholder="Password"
                    value={credentials.password}
                    onChange={handleChange}
                    required
                />
                <button type="submit" className="login-btn">Login</button>
                {error && <p className="error-msg">{error}</p>} {/* Display error if there's any */}
            </form>
            <p>Don't have an account? <Link to="/register" className="register-link">Register here</Link></p>
        </div>
    );
};

export default LoginPage;
