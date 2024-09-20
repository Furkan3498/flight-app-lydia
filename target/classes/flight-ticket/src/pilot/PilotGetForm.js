import React, { useEffect, useState } from 'react';
import axios from 'axios';

const PilotFetchData = () => {
    const [data, setData] = useState([]);

    useEffect(() => {
        axios.get('http://localhost:8080/api/pilots')  // Adjust API URL as needed
            .then(response => {
                setData(response.data);
            })
            .catch(error => {
                console.error("Error fetching data: ", error);
            });
    }, []);

    return (
        <div>
            <h2>All Pilots</h2>
            <table border="1">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Licence</th>
                    <th>Identity Number</th>
                    <th>Email</th>
                    <th>Phone Number</th>
                </tr>
                </thead>
                <tbody>
                {data.map((item) => (
                    <tr key={item.id}>
                        <td>{item.id}</td>
                        <td>{item.pilotFirstName}</td>
                        <td>{item.pilotLastName}</td>
                        <td>{item.pilotLicence}</td>
                        <td>{item.pilotIdentityNumber}</td>
                        <td>{item.pilotEmail}</td>
                        <td>{item.pilotPhoneNumber}</td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
};

export default PilotFetchData;
