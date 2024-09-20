import React, { useState } from 'react';
import axios from 'axios';

const CountryPostForm = () => {
    const [formData, setFormData] = useState({ countryName: ''});

    const handleSubmit = (e) => {
        e.preventDefault();
        axios.post('http://localhost:8080/api/countries', formData)
            .then(response => {
                alert('Post Created Successfully');
                setFormData({countryName: ''});
            })
            .catch(error => {
                console.error("There was an error creating the post!", error);
            });
    };

    return (
        <div>
            <h2>Add New Country</h2>
            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    placeholder="Country Name"
                    value={formData.countryName}
                    onChange={(e) => setFormData({ ...formData, countryName: e.target.value })}
                />
                <button type="submit">Submit</button>
            </form>
        </div>
    );
};

export default CountryPostForm;
