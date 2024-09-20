import React, { useEffect, useState } from 'react';
import axios from 'axios';

const AirplaneFetchData = () => {
    const [data, setData] = useState([]);

    useEffect(() => {
        axios.get('http://localhost:8080/api/airplanes')  // Adjust API URL as needed
            .then(response => {
                setData(response.data);
            })
            .catch(error => {
                console.error("Error fetching data: ", error);
            });
    }, []);

    return (
        <div>
            <h2>All Airplanes</h2>
            <table border="1">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Airplane Name</th>
                    <th>Airplane Capacity</th>
                    <th>Airplane Details</th>
                </tr>
                </thead>
                <tbody>
                {data.map((item) => (
                    <tr key={item.id}>
                        <td>{item.id}</td>
                        <td>{item.airplaneName}</td>
                        <td>{item.airplaneCapacity}</td>
                        <td>{item.airplaneDetails}</td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
};

export default AirplaneFetchData;
