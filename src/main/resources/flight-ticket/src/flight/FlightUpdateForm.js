import React, { useState } from 'react';
import axios from 'axios';

const FlightUpdateForm = () => {
    const [updateData, setUpdateData] = useState({id: '', flightCode: '', depatureTime: '', arrivalTime: '', rotationId: '', pilotId: '', companyId: '',
        airplaneId: '', ticketPriceId: ''});

    const handleSubmit = (e) => {
        e.preventDefault();
        axios.put(`http://localhost:8080/api/flights/${updateData.id}`, updateData)
            .then(response => {
                alert('Flight Updated Successfully');
                setUpdateData({ id: '', countryName: ''});
            })
            .catch(error => {
                console.error("There was an error updating the flight!", error);
            });
    };

    return (
        <div>
            <h2>Update Flight</h2>
            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    placeholder="ID"
                    value={updateData.id}
                    onChange={(e) => setUpdateData({...updateData, id: e.target.value})}
                />
                <input
                    type="text"
                    placeholder="Flight Code"
                    value={updateData.flightCode}
                    onChange={(e) => setUpdateData({...updateData, flightCode: e.target.value})}
                />
                <input
                    type="text"
                    placeholder="Departure Time"
                    value={updateData.depatureTime}
                    onChange={(e) => setUpdateData({...updateData, depatureTime: e.target.value})}
                />
                <input
                    type="text"
                    placeholder="Arrival Time"
                    value={updateData.arrivalTime}
                    onChange={(e) => setUpdateData({...updateData, arrivalTime: e.target.value})}
                />
                <input
                    type="text"
                    placeholder="Rotation ID"
                    value={updateData.rotationId}
                    onChange={(e) => setUpdateData({...updateData, rotationId: e.target.value})}
                />
                <input
                    type="text"
                    placeholder="Pilot ID"
                    value={updateData.pilotId}
                    onChange={(e) => setUpdateData({...updateData, pilotId: e.target.value})}
                />
                <input
                    type="text"
                    placeholder="Company ID"
                    value={updateData.companyId}
                    onChange={(e) => setUpdateData({...updateData, companyId: e.target.value})}
                />
                <input
                    type="text"
                    placeholder="Ticket Price ID"
                    value={updateData.ticketPriceId}
                    onChange={(e) => setUpdateData({...updateData, ticketPriceId: e.target.value})}
                />
                <button type="submit">Update</button>
            </form>
        </div>
    );
};

export default FlightUpdateForm;
