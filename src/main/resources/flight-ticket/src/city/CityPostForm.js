import React, { useState } from 'react';
import axios from 'axios';

const CityPostForm = () => {
    const [formData, setFormData] = useState({ cityName: '', countryId: ''});

    const handleSubmit = (e) => {
        e.preventDefault();
        axios.post('http://localhost:8080/api/cities', formData)
            .then(response => {
                alert('Post Created Successfully');
                setFormData({cityName: '',countryId: ''});
            })
            .catch(error => {
                console.error("There was an error creating the post!", error);
            });
    };

    return (
        <div>
            <h2>Add New City</h2>
            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    placeholder="City Name"
                    value={formData.cityName}
                    onChange={(e) => setFormData({...formData, cityName: e.target.value})}
                />
                <input
                    type="text"
                    placeholder="Country ID"
                    value={formData.countryId}
                    onChange={(e) => setFormData({...formData, countryId: e.target.value})}
                />
                <button type="submit">Submit</button>
            </form>
        </div>
    );
};

export default CityPostForm;
