import React, { useState } from 'react';
import axios from 'axios';

const AirportPostForm = () => {
    const [formData, setFormData] = useState({ name: '', details: '', gateCapacity: '', cityId: ''});

    const handleSubmit = (e) => {
        e.preventDefault();
        axios.post('http://localhost:8080/api/airports', formData)
            .then(response => {
                alert('Post Created Successfully');
                setFormData({ name: '', details: '', gateCapacity: '', cityId: ''});
            })
            .catch(error => {
                console.error("There was an error creating the post!", error);
            });
    };

    return (
        <div>
            <h2>Add New Airport</h2>
            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    placeholder="Airport Name"
                    value={formData.name}
                    onChange={(e) => setFormData({...formData, name: e.target.value})}
                />
                <input
                    type="text"
                    placeholder="Details"
                    value={formData.details}
                    onChange={(e) => setFormData({...formData, details: e.target.value})}
                />
                <input
                    type="text"
                    placeholder="Gate Capacity"
                    value={formData.gateCapacity}
                    onChange={(e) => setFormData({...formData, gateCapacity: e.target.value})}
                />
                <input
                    type="text"
                    placeholder="City ID"
                    value={formData.cityId}
                    onChange={(e) => setFormData({...formData, cityId: e.target.value})}
                />
                <button type="submit">Submit</button>
            </form>
        </div>
    );
};

export default AirportPostForm;
