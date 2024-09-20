import React, { useState } from 'react';
import axios from 'axios';

const PilotUpdateForm = () => {
    const [updateData, setUpdateData] = useState({ id: '', pilotFirstName: '', pilotLicence: '', pilotLastName: '', pilotIdentityNumber: '',
        pilotEmail: '', pilotPhoneNumber: ''});

    const handleSubmit = (e) => {
        e.preventDefault();
        axios.put(`http://localhost:8080/api/pilots/${updateData.id}`, updateData)
            .then(response => {
                alert('Pilot Updated Successfully');
                setUpdateData({ id: '', pilotFirstName: '', pilotLicence: '', pilotLastName: '', pilotIdentityNumber: '',
                    pilotEmail: '', pilotPhoneNumber: ''});
            })
            .catch(error => {
                console.error("There was an error updating the pilot!", error);
            });
    };

    return (
        <div>
            <h2>Update Pilot</h2>
            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    placeholder="ID"
                    value={updateData.id}
                    onChange={(e) => setUpdateData({...updateData, id: e.target.value})}
                />
                <input
                    type="text"
                    placeholder="First Name"
                    value={updateData.pilotFirstName}
                    onChange={(e) => setUpdateData({...updateData, pilotFirstName: e.target.value})}
                />
                <input
                    type="text"
                    placeholder="Last Name"
                    value={updateData.pilotLastName}
                    onChange={(e) => setUpdateData({...updateData, pilotLastName: e.target.value})}
                />
                <input
                    type="text"
                    placeholder="Licence"
                    value={updateData.pilotLicence}
                    onChange={(e) => setUpdateData({...updateData, pilotLicence: e.target.value})}
                />
                <input
                    type="text"
                    placeholder="Email"
                    value={updateData.pilotEmail}
                    onChange={(e) => setUpdateData({...updateData, pilotEmail: e.target.value})}
                />
                <input
                    type="text"
                    placeholder="Phone Number"
                    value={updateData.pilotPhoneNumber}
                    onChange={(e) => setUpdateData({...updateData, pilotPhoneNumber: e.target.value})}
                />
                <input
                    type="text"
                    placeholder="Identity Number"
                    value={updateData.pilotIdentityNumber}
                    onChange={(e) => setUpdateData({...updateData, pilotIdentityNumber: e.target.value})}
                />
                <button type="submit">Update</button>
            </form>
        </div>
    );
};

export default PilotUpdateForm;
