import React, { useEffect, useState } from 'react';
import axios from 'axios';

const FlightFetchData = () => {
    const [data, setData] = useState([]);

    useEffect(() => {
        axios.get('http://localhost:8080/api/flights')  // Adjust API URL as needed
            .then(response => {
                setData(response.data);
            })
            .catch(error => {
                console.error("Error fetching data: ", error);
            });
    }, []);

    return (
        <div>
            <h2>All Flights</h2>
            <table border="1">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Flight Code</th>
                    <th>Departure Time</th>
                    <th>Arrival Time</th>
                    <th>Rotation ID</th>
                </tr>
                </thead>
                <tbody>
                {data.map((item) => (
                    <tr key={item.id}>
                        <td>{item.id}</td>
                        <td>{item.flightCode}</td>
                        <td>{item.depatureTime}</td>
                        <td>{item.arrivalTime}</td>
                        <td>{item.rotationId}</td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
};

export default FlightFetchData;
