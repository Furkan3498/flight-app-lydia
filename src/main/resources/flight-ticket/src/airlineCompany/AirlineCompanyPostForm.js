import React, { useState } from 'react';
import axios from 'axios';

const AirlineCompanyPostForm = () => {
    const [formData, setFormData] = useState({ companyName: '', companyDetail: ''});

    const handleSubmit = (e) => {
        e.preventDefault();
        axios.post('http://localhost:8080/api/airlinecompanies', formData)
            .then(response => {
                alert('Post Created Successfully');
                setFormData({companyName: '', companyDetail: ''});
            })
            .catch(error => {
                console.error("There was an error creating the post!", error);
            });
    };

    return (
        <div>
            <h2>Add New Company</h2>
            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    placeholder="City Name"
                    value={formData.companyName}
                    onChange={(e) => setFormData({...formData, companyName: e.target.value})}
                />
                <input
                    type="text"
                    placeholder="Country ID"
                    value={formData.companyDetail}
                    onChange={(e) => setFormData({...formData, companyDetail: e.target.value})}
                />
                <button type="submit">Submit</button>
            </form>
        </div>
    );
};

export default AirlineCompanyPostForm;
