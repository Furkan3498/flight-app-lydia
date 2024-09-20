import React, { useEffect, useState } from 'react';
import axios from 'axios';

const AirportFetchData = () => {
    const [data, setData] = useState([]);

    useEffect(() => {
        axios.get('http://localhost:8080/api/airports')  // Adjust API URL as needed
            .then(response => {
                setData(response.data);
            })
            .catch(error => {
                console.error("Error fetching data: ", error);
            });
    }, []);

    return (
        <div>
            <h2>All Airports</h2>
            <table border="1">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Airport Name</th>
                    <th>Details</th>
                    <th>Gate Capacity</th>
                    <th>City ID</th>
                </tr>
                </thead>
                <tbody>
                {data.map((item) => (
                    <tr key={item.id}>
                        <td>{item.id}</td>
                        <td>{item.name}</td>
                        <td>{item.details}</td>
                        <td>{item.gateCapacity}</td>
                        <td>{item.cityId}</td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
};

export default AirportFetchData;
