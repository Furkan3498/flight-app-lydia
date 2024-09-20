import React, { useState } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';
import './LoginPage.css'; // Reuse the same CSS for styling

const RegisterPage = ({ setRegistered }) => {
    const [user, setUser] = useState({
        userEmail: '',
        userPassword: '',
        userFirstName: '',
        userLastName: '',
        userIdentityNumber: '',
        userPhoneNumber: ''
    });

    const [error, setError] = useState('');
    const [success, setSuccess] = useState('');

    const handleChange = (e) => {
        const { name, value } = e.target;
        setUser({
            ...user,
            [name]: value
        });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        axios.post('http://localhost:8080/register', user)
            .then(response => {
                setSuccess('Registration successful! You can now log in.');
                setError('');
                setUser({userEmail: '',
                    userPassword: '',
                    userFirstName: '',
                    userLastName: '',
                    userIdentityNumber: '',
                    userPhoneNumber: ''});
                setTimeout(() => setRegistered(true), 2000); // Redirect to login after success
            })
            .catch(error => {
                setError('Registration failed. Please try again.');
            });
    };

    return (
        <div className="login-container">
            <h2>Register</h2>
            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    name="userEmail"
                    placeholder="Email"
                    value={user.userEmail}
                    onChange={handleChange}
                    required
                />
                <input
                    type="password"
                    name="userPassword"
                    placeholder="Password"
                    value={user.userPassword}
                    onChange={handleChange}
                    required
                />
                <input
                    type="text"
                    name="userFirstName"
                    placeholder="First Name"
                    value={user.userFirstName}
                    onChange={handleChange}
                    required
                />
                <input
                    type="text"
                    name="userLastName"
                    placeholder="Last Name"
                    value={user.userLastName}
                    onChange={handleChange}
                    required
                />
                <input
                    type="text"
                    name="userPhoneNumber"
                    placeholder="Phone Number"
                    value={user.userPhoneNumber}
                    onChange={handleChange}
                    required
                />
                <input
                    type="text"
                    name="userIdentityNumber"
                    placeholder="Identity Number"
                    value={user.userIdentityNumber}
                    onChange={handleChange}
                    required
                />
                <button type="submit" className="login-btn">Register</button>
                {error && <p className="error-msg">{error}</p>}
                {success && <p className="success-msg">{success}</p>}
            </form>
            <p>Already have an account? <Link to="/login" className="register-link">Login here</Link></p>
        </div>
    );
};

export default RegisterPage;
