import React, { useState } from 'react';
import axios from 'axios';

const TicketPriceUpdateForm = () => {
    const [updateData, setUpdateData] = useState({ id: '', amount: ''});

    const handleSubmit = (e) => {
        e.preventDefault();
        axios.put(`http://localhost:8080/api/ticketprices/${updateData.id}`, updateData)
            .then(response => {
                alert('Price Updated Successfully');
                setUpdateData({ id: '', amount: ''});
            })
            .catch(error => {
                console.error("There was an error updating the price!", error);
            });
    };

    return (
        <div>
            <h2>Update Ticket Price</h2>
            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    placeholder="ID"
                    value={updateData.id}
                    onChange={(e) => setUpdateData({ ...updateData, id: e.target.value })}
                />
                <input
                    type="number"
                    placeholder="Amount"
                    value={updateData.amount}
                    onChange={(e) => setUpdateData({ ...updateData, amount: e.target.value })}
                />
                <button type="submit">Update</button>
            </form>
        </div>
    );
};

export default TicketPriceUpdateForm;
