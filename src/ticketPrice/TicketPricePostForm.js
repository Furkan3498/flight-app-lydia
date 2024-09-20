import React, { useState } from 'react';
import axios from 'axios';

const TicketPricePostForm = () => {
    const [formData, setFormData] = useState({ amount: ''});

    const handleSubmit = (e) => {
        e.preventDefault();
        axios.post('http://localhost:8080/api/ticketprices', formData)
            .then(response => {
                alert('Post Created Successfully');
                setFormData({amount: ''});
            })
            .catch(error => {
                console.error("There was an error creating the post!", error);
            });
    };

    return (
        <div>
            <h2>Add New Ticket Price</h2>
            <form onSubmit={handleSubmit}>
                <input
                    type="number"
                    placeholder="Ticket Amount"
                    value={formData.amount}
                    onChange={(e) => setFormData({...formData, amount: e.target.value})}
                />
                <button type="submit">Submit</button>
            </form>
        </div>
    );
};

export default TicketPricePostForm;
