import React, { useEffect, useState } from 'react';
import axios from 'axios';

const TicketPriceFetchData = () => {
    const [data, setData] = useState([]);

    useEffect(() => {
        axios.get('http://localhost:8080/api/ticketprices')  // Adjust API URL as needed
            .then(response => {
                setData(response.data);
            })
            .catch(error => {
                console.error("Error fetching data: ", error);
            });
    }, []);

    return (
        <div>
            <h2>All Ticket Prices</h2>
            <table border="1">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Ticket Price</th>
                </tr>
                </thead>
                <tbody>
                {data.map((item) => (
                    <tr key={item.id}>
                        <td>{item.id}</td>
                        <td>{item.amount}</td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
};

export default TicketPriceFetchData;
