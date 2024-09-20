import React, { useState } from 'react';
import axios from 'axios';

const AirportUpdateForm = () => {
    const [updateData, setUpdateData] = useState({ id: '', name: '', details: '', gateCapacity: '', cityId: ''});

    const handleSubmit = (e) => {
        e.preventDefault();
        axios.put(`http://localhost:8080/api/airports/${updateData.id}`, updateData)
            .then(response => {
                alert('City Updated Successfully');
                setUpdateData({ id: '', name: '', details: '', gateCapacity: '', cityId: ''});
            })
            .catch(error => {
                console.error("There was an error updating the city!", error);
            });
    };

    return (
        <div>
            <h2>Update Airport</h2>
            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    placeholder="ID"
                    value={updateData.id}
                    onChange={(e) => setUpdateData({...updateData, id: e.target.value})}
                />
                <input
                    type="text"
                    placeholder="Airport Name"
                    value={updateData.name}
                    onChange={(e) => setUpdateData({...updateData, name: e.target.value})}
                />
                <input
                    type="text"
                    placeholder="Details"
                    value={updateData.details}
                    onChange={(e) => setUpdateData({...updateData, details: e.target.value})}
                />
                <input
                    type="text"
                    placeholder="Gate Capacity"
                    value={updateData.gateCapacity}
                    onChange={(e) => setUpdateData({...updateData, gateCapacity: e.target.value})}
                />
                <input
                    type="text"
                    placeholder="City ID"
                    value={updateData.cityId}
                    onChange={(e) => setUpdateData({...updateData, cityId: e.target.value})}
                />
                <button type="submit">Update</button>
            </form>
        </div>
    );
};

export default AirportUpdateForm;
