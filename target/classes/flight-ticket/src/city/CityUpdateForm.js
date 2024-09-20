import React, { useState } from 'react';
import axios from 'axios';

const CityUpdateForm = () => {
    const [updateData, setUpdateData] = useState({ id: '', cityName: ''});

    const handleSubmit = (e) => {
        e.preventDefault();
        axios.put(`http://localhost:8080/api/cities/${updateData.id}`, updateData)
            .then(response => {
                alert('City Updated Successfully');
                setUpdateData({ id: '', countryName: ''});
            })
            .catch(error => {
                console.error("There was an error updating the city!", error);
            });
    };

    return (
        <div>
            <h2>Update City</h2>
            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    placeholder="ID"
                    value={updateData.id}
                    onChange={(e) => setUpdateData({ ...updateData, id: e.target.value })}
                />
                <input
                    type="text"
                    placeholder="City Name"
                    value={updateData.cityName}
                    onChange={(e) => setUpdateData({ ...updateData, countryName: e.target.value })}
                />
                <button type="submit">Update</button>
            </form>
        </div>
    );
};

export default CityUpdateForm;
