import React, { useState } from 'react';
import axios from 'axios';

const AddressPostForm = () => {
    const [formData, setFormData] = useState({ cityId: '', address: '', addressRegion: '', addressPostalcode: ''});

    const handleSubmit = (e) => {
        e.preventDefault();
        axios.post('http://localhost:8080/api/addresses', formData)
            .then(response => {
                alert('Post Created Successfully');
                setFormData({cityId: '',address: '', addressRegion: '', addressPostalcode: ''});
            })
            .catch(error => {
                console.error("There was an error creating the post!", error);
            });
    };

    return (
        <div>
            <h2>Add New Address</h2>
            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    placeholder="City ID"
                    value={formData.cityId}
                    onChange={(e) => setFormData({...formData, cityId: e.target.value})}
                />
                <input
                    type="text"
                    placeholder="Address"
                    value={formData.address}
                    onChange={(e) => setFormData({...formData, address: e.target.value})}
                />
                <input
                    type="text"
                    placeholder="Address Region"
                    value={formData.addressRegion}
                    onChange={(e) => setFormData({...formData, addressRegion: e.target.value})}
                />
                <input
                    type="text"
                    placeholder="Postal Code"
                    value={formData.addressPostalcode}
                    onChange={(e) => setFormData({...formData, addressPostalcode: e.target.value})}
                />
                <button type="submit">Submit</button>
            </form>
        </div>
    );
};

export default AddressPostForm;
