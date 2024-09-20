import React, { useState } from 'react';
import axios from 'axios';

const TicketBookingPostForm = () => {
    const [formData, setFormData] = useState({ userId: '', flightId: '', numberOfTicket: ''});

    const handleSubmit = (e) => {
        e.preventDefault();
        axios.post('http://localhost:8080/api/ticketbookings', formData)
            .then(response => {
                alert('Post Created Successfully');
                setFormData({ userId: '', flightId: '', numberOfTicket: ''});
            })
            .catch(error => {
                console.error("There was an error creating the post!", error);
            });
    };

    return (
        <div>
            <h2>Add New Ticket Book</h2>
            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    placeholder="User ID"
                    value={formData.userId}
                    onChange={(e) => setFormData({...formData, userId: e.target.value})}
                />
                <input
                    type="text"
                    placeholder="Flight ID"
                    value={formData.flightId}
                    onChange={(e) => setFormData({...formData, flightId: e.target.value})}
                />
                <input
                    type="number"
                    placeholder="Number of Ticket"
                    value={formData.numberOfTicket}
                    onChange={(e) => setFormData({...formData, numberOfTicket: e.target.value})}
                />
                <button type="submit">Submit</button>
            </form>
        </div>
    );
};

export default TicketBookingPostForm;
