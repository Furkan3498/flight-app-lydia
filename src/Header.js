import React from 'react';
import './Header.css';
const Header = ({ user, onLogout }) => {
    return (
        <header className="header">
            <div className="header-content">
                <button className="logout-btn" onClick={onLogout}>Logout</button>
            </div>
        </header>
    );
};

export default Header;
