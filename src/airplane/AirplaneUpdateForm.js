import React, { useState } from 'react';
import axios from 'axios';

const AirplaneUpdateForm = () => {
    const [updateData, setUpdateData] = useState({ id: '', airplaneName: '', airplaneCapacity: '', airplaneManufacturer: '', airplaneDetails: ''});

    const handleSubmit = (e) => {
        e.preventDefault();
        axios.put(`http://localhost:8080/api/airplanes/${updateData.id}`, updateData)
            .then(response => {
                alert('City Updated Successfully');
                setUpdateData({ id: '', airplaneName: '', airplaneCapacity: '', airplaneManufacturer: '', airplaneDetails: ''});
            })
            .catch(error => {
                console.error("There was an error updating the city!", error);
            });
    };

    return (
        <div>
            <h2>Update Airplane</h2>
            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    placeholder="ID"
                    value={updateData.id}
                    onChange={(e) => setUpdateData({...updateData, id: e.target.value})}
                />
                <input
                    type="text"
                    placeholder="Airplane Name"
                    value={updateData.airplaneName}
                    onChange={(e) => setUpdateData({...updateData, airplaneName: e.target.value})}
                />
                <input
                    type="text"
                    placeholder="Manufacturer"
                    value={updateData.airplaneManufacturer}
                    onChange={(e) => setUpdateData({...updateData, airplaneManufacturer: e.target.value})}
                />
                <input
                    type="text"
                    placeholder="Capacity"
                    value={updateData.airplaneCapacity}
                    onChange={(e) => setUpdateData({...updateData, airplaneCapacity: e.target.value})}
                />
                <input
                    type="text"
                    placeholder="Airplane Details"
                    value={updateData.airplaneDetails}
                    onChange={(e) => setUpdateData({...updateData, airplaneDetails: e.target.value})}
                />
                <button type="submit">Update</button>
            </form>
        </div>
    );
};

export default AirplaneUpdateForm;
