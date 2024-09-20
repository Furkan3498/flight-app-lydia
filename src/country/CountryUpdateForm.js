import React, { useState } from 'react';
import axios from 'axios';

const CountryUpdateForm = () => {
    const [updateData, setUpdateData] = useState({ id: '', countryName: ''});

    const handleSubmit = (e) => {
        e.preventDefault();
        axios.put(`http://localhost:8080/api/countries/${updateData.id}`, updateData)
            .then(response => {
                alert('Post Updated Successfully');
                setUpdateData({ id: '', countryName: ''});
            })
            .catch(error => {
                console.error("There was an error updating the post!", error);
            });
    };

    return (
        <div>
            <h2>Update Country</h2>
            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    placeholder="ID"
                    value={updateData.id}
                    onChange={(e) => setUpdateData({ ...updateData, id: e.target.value })}
                />
                <input
                    type="text"
                    placeholder="Country Name"
                    value={updateData.countryName}
                    onChange={(e) => setUpdateData({ ...updateData, countryName: e.target.value })}
                />
                <button type="submit">Update</button>
            </form>
        </div>
    );
};

export default CountryUpdateForm;
