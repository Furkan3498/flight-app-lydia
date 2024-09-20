import React, { useState } from 'react';
import axios from 'axios';

const AirplanePostForm = () => {
    const [formData, setFormData] = useState({ airplaneName: '', airplaneCapacity: '', airplaneManufacturer: '', airplaneDetails: ''});

    const handleSubmit = (e) => {
        e.preventDefault();
        axios.post('http://localhost:8080/api/airplanes', formData)
            .then(response => {
                alert('Post Created Successfully');
                setFormData({airplaneName: '', airplaneCapacity: '', airplaneManufacturer: '', airplaneDetails: ''});
            })
            .catch(error => {
                console.error("There was an error creating the post!", error);
            });
    };

    return (
        <div>
            <h2>Add New Airplane</h2>
            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    placeholder="Airplane Name"
                    value={formData.airplaneName}
                    onChange={(e) => setFormData({...formData, airplaneName: e.target.value})}
                />
                <input
                    type="text"
                    placeholder="Manufacturer"
                    value={formData.airplaneManufacturer}
                    onChange={(e) => setFormData({...formData, airplaneManufacturer: e.target.value})}
                />
                <input
                    type="text"
                    placeholder="Capacity"
                    value={formData.airplaneCapacity}
                    onChange={(e) => setFormData({...formData, airplaneCapacity: e.target.value})}
                />
                <input
                    type="text"
                    placeholder="Details"
                    value={formData.airplaneDetails}
                    onChange={(e) => setFormData({...formData, airplaneDetails: e.target.value})}
                />
                <button type="submit">Submit</button>
            </form>
        </div>
    );
};

export default AirplanePostForm;
