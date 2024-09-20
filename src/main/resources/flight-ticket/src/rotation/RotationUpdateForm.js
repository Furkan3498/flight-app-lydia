import React, { useState } from 'react';
import axios from 'axios';

const RotationUpdateForm = () => {
    const [updateData, setUpdateData] = useState({ departureAirportId: '', arrivalAirportId: ''});

    const handleSubmit = (e) => {
        e.preventDefault();
        axios.put(`http://localhost:8080/api/rotations/${updateData.id}`, updateData)
            .then(response => {
                alert('Rotation Updated Successfully');
                setUpdateData({  departureAirportId: '', arrivalAirportId: ''});
            })
            .catch(error => {
                console.error("There was an error updating the rotation!", error);
            });
    };

    return (
        <div>
            <h2>Update Rotation</h2>
            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    placeholder="Departure Airport ID"
                    value={updateData.departureAirportId}
                    onChange={(e) => setUpdateData({ ...updateData, departureAirportId: e.target.value })}
                />
                <input
                    type="text"
                    placeholder="Arrival Airport ID"
                    value={updateData.arrivalAirportId}
                    onChange={(e) => setUpdateData({ ...updateData, arrivalAirportId: e.target.value })}
                />
                <button type="submit">Update</button>
            </form>
        </div>
    );
};

export default RotationUpdateForm;
