import React, { useState } from 'react';
import axios from 'axios';

const PilotPostForm = () => {
    const [formData, setFormData] = useState({ pilotFirstName: '', pilotLicence: '', pilotLastName: '', pilotIdentityNumber: '',
        pilotEmail: '', pilotPhoneNumber: ''});

    const handleSubmit = (e) => {
        e.preventDefault();
        axios.post('http://localhost:8080/api/pilots', formData)
            .then(response => {
                alert('Post Created Successfully');
                setFormData({pilotFirstName: '', pilotLicence: '', pilotLastName: '', pilotIdentityNumber: '',
                    pilotEmail: '', pilotPhoneNumber: ''});
            })
            .catch(error => {
                console.error("There was an error creating the post!", error);
            });
    };

    return (
        <div>
            <h2>Add New Pilot</h2>
            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    placeholder="First Name"
                    value={formData.pilotFirstName}
                    onChange={(e) => setFormData({...formData, pilotFirstName: e.target.value})}
                />
                <input
                    type="text"
                    placeholder="Last Name"
                    value={formData.pilotLastName}
                    onChange={(e) => setFormData({...formData, pilotLastName: e.target.value})}
                />
                <input
                    type="text"
                    placeholder="Licence"
                    value={formData.pilotLicence}
                    onChange={(e) => setFormData({...formData, pilotLicence: e.target.value})}
                />
                <input
                    type="text"
                    placeholder="Identity Number"
                    value={formData.pilotIdentityNumber}
                    onChange={(e) => setFormData({...formData, pilotIdentityNumber: e.target.value})}
                />
                <input
                    type="text"
                    placeholder="Email"
                    value={formData.pilotEmail}
                    onChange={(e) => setFormData({...formData, pilotEmail: e.target.value})}
                />
                <input
                    type="text"
                    placeholder="Phone"
                    value={formData.pilotPhoneNumber}
                    onChange={(e) => setFormData({...formData, pilotPhoneNumber: e.target.value})}
                />
                <button type="submit">Submit</button>
            </form>
        </div>
    );
};

export default PilotPostForm;
