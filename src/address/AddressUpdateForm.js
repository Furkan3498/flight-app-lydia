import React, { useState } from 'react';
import axios from 'axios';

const AddressUpdateForm = () => {
    const [updateData, setUpdateData] = useState({cityId: '', id: '', address: '',  addressRegion: '', addressPostalcode: ''});

    const handleSubmit = (e) => {
        e.preventDefault();
        axios.put(`http://localhost:8080/api/addresses/${updateData.id}`, updateData)
            .then(response => {
                alert('Address Updated Successfully');
                setUpdateData({ cityId: '',id: '', address: '',  addressRegion: '', addressPostalcode: ''});
            })
            .catch(error => {
                console.error("There was an error updating the address!", error);
            });
    };

    return (
        <div>
            <h2>Update Address</h2>
            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    placeholder="ID"
                    value={updateData.id}
                    onChange={(e) => setUpdateData({...updateData, id: e.target.value})}
                />
                <input
                    type="number"
                    placeholder="City ID"
                    value={updateData.cityId}
                    onChange={(e) => setUpdateData({...updateData, cityId: e.target.value})}
                />
                <input
                    type="text"
                    placeholder="Address"
                    value={updateData.address}
                    onChange={(e) => setUpdateData({...updateData, address: e.target.value})}
                />
                <input
                    type="text"
                    placeholder="Address Region"
                    value={updateData.addressRegion}
                    onChange={(e) => setUpdateData({...updateData, addressRegion: e.target.value})}
                />
                <input
                    type="text"
                    placeholder="Postal Code"
                    value={updateData.addressPostalcode}
                    onChange={(e) => setUpdateData({...updateData, addressPostalcode: e.target.value})}
                />
                <button type="submit">Update</button>
            </form>
        </div>
    );
};

export default AddressUpdateForm;
