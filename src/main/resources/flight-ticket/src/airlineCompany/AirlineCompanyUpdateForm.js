import React, { useState } from 'react';
import axios from 'axios';

const AirlineCompanyUpdateForm = () => {
    const [updateData, setUpdateData] = useState({ id: '', companyName: '', companyDetails: ''});

    const handleSubmit = (e) => {
        e.preventDefault();
        axios.put(`http://localhost:8080/api/airlinecompanies/${updateData.id}`, updateData)
            .then(response => {
                alert('City Updated Successfully');
                setUpdateData({ id: '', companyName: '', companyDetails: ''});
            })
            .catch(error => {
                console.error("There was an error updating the city!", error);
            });
    };

    return (
        <div>
            <h2>Update Company</h2>
            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    placeholder="ID"
                    value={updateData.id}
                    onChange={(e) => setUpdateData({...updateData, id: e.target.value})}
                />
                <input
                    type="text"
                    placeholder="Company Name"
                    value={updateData.companyName}
                    onChange={(e) => setUpdateData({...updateData, companyName: e.target.value})}
                />
                <input
                    type="text"
                    placeholder="Company Details"
                    value={updateData.companyDetails}
                    onChange={(e) => setUpdateData({...updateData, companyDetails: e.target.value})}
                />
                <button type="submit">Update</button>
            </form>
        </div>
    );
};

export default AirlineCompanyUpdateForm;
