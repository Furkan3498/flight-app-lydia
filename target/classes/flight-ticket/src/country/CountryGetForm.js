import React, { useEffect, useState } from 'react';
import axios from 'axios';

const CountryFetchData = () => {
    const [data, setData] = useState([]);

    useEffect(() => {
        axios.get('http://localhost:8080/api/countries')  // Adjust API URL as needed
            .then(response => {
                setData(response.data);
            })
            .catch(error => {
                console.error("Error fetching data: ", error);
            });
    }, []);

    return (
        <div>
            <h2>All Countries</h2>
            <table border="1">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Title</th>
                    <th>Description</th>
                </tr>
                </thead>
                <tbody>
                {data.map((item) => (
                    <tr key={item.id}>
                        <td>{item.id}</td>
                        <td>{item.countryName}</td>  {/* Assuming 'countryName' corresponds to 'Title' */}
                        <td>Description Placeholder</td> {/* Add the correct field if there’s a description */}
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
};

export default CountryFetchData;
