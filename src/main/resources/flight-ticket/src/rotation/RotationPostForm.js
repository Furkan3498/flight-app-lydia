import React, { useState } from 'react';
import axios from 'axios';

const RotationPostForm = () => {
    const [formData, setFormData] = useState({ departureAirportId: '', arrivalAirportId: ''});

    const handleSubmit = (e) => {
        e.preventDefault();
        axios.post('http://localhost:8080/api/rotations', formData)
            .then(response => {
                alert('Post Created Successfully');
                setFormData({departureAirportId: '', arrivalAirportId: ''});
            })
            .catch(error => {
                console.error("There was an error creating the post!", error);
            });
    };

    return (
        <div>
            <h2>Add New Rotation</h2>
            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    placeholder="Departure Airport ID"
                    value={formData.departureAirportId}
                    onChange={(e) => setFormData({...formData, departureAirportId: e.target.value})}
                />
                <input
                    type="text"
                    placeholder="Arrival Airport ID"
                    value={formData.arrivalAirportId}
                    onChange={(e) => setFormData({...formData, arrivalAirportId: e.target.value})}
                />
                <button type="submit">Submit</button>
            </form>
        </div>
    );
};

export default RotationPostForm;
