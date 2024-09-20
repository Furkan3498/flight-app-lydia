import React, { useEffect, useState } from 'react';
import axios from 'axios';

const RotationFetchData = () => {
    const [data, setData] = useState([]);

    useEffect(() => {
        axios.get('http://localhost:8080/api/rotations')  // Adjust API URL as needed
            .then(response => {
                setData(response.data);
            })
            .catch(error => {
                console.error("Error fetching data: ", error);
            });
    }, []);

    return (
        <div>
            <h2>All Rotations</h2>
            <table border="1">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Departure Airport ID</th>
                    <th>Arrival Airport ID</th>
                    <th>Description</th>
                </tr>
                </thead>
                <tbody>
                {data.map((item) => (
                    <tr key={item.id}>
                        <td>{item.id}</td>
                        <td>{item.departureAirportId}</td>
                        <td>{item.arrivalAirportId}</td>
                        <td>Description Placeholder</td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
};

export default RotationFetchData;
