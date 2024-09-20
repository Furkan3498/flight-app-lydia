import React, { useState } from 'react';
import axios from 'axios';

const TicketBookingUpdateForm = () => {
    const [updateData, setUpdateData] = useState({ id: '', userId: '', flightId: '', numberOfTicket: ''});

    const handleSubmit = (e) => {
        e.preventDefault();
        axios.put(`http://localhost:8080/api/ticketbookings/${updateData.id}`, updateData)
            .then(response => {
                alert('City Updated Successfully');
                setUpdateData({ id: '', userId: '', flightId: '', numberOfTicket: ''});
            })
            .catch(error => {
                console.error("There was an error updating the city!", error);
            });
    };

    return (
        <div>
            <h2>Update Ticket Book</h2>
            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    placeholder="ID"
                    value={updateData.id}
                    onChange={(e) => setUpdateData({...updateData, id: e.target.value})}
                />
                <input
                    type="text"
                    placeholder="User ID"
                    value={updateData.userId}
                    onChange={(e) => setUpdateData({...updateData, userId: e.target.value})}
                />
                <input
                    type="text"
                    placeholder="Flight ID"
                    value={updateData.flightId}
                    onChange={(e) => setUpdateData({...updateData, flightId: e.target.value})}
                />
                <input
                    type="text"
                    placeholder="Number of Ticket"
                    value={updateData.numberOfTicket}
                    onChange={(e) => setUpdateData({...updateData, numberOfTicket: e.target.value})}
                />
                <button type="submit">Update</button>
            </form>
        </div>
    );
};

export default TicketBookingUpdateForm;
