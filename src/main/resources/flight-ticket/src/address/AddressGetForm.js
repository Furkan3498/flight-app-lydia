import React, { useEffect, useState } from 'react';
import axios from 'axios';

const AddressFetchData = () => {
    const [data, setData] = useState([]);

    useEffect(() => {
        axios.get('http://localhost:8080/api/addresses')  // Adjust API URL as needed
            .then(response => {
                setData(response.data);
            })
            .catch(error => {
                console.error("Error fetching data: ", error);
            });
    }, []);

    return (
        <div>
            <h2>All Addresses</h2>
            <table border="1">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>City ID</th>
                    <th>Address</th>
                    <th>Address Region</th>
                    <th>Postal Code</th>
                </tr>
                </thead>
                <tbody>
                {data.map((item) => (
                    <tr key={item.id}>
                        <td>{item.id}</td>
                        <td>{item.cityId}</td>
                        <td>{item.address}</td>
                        <td>{item.addressRegion}</td>
                        <td>{item.addressPostalcode}</td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
};

export default AddressFetchData;
