import React, { useEffect, useState } from 'react';
import axios from 'axios';

const CityDeleteData = () => {
    const [data, setData] = useState([]);

    // Fetch data from backend
    useEffect(() => {
        axios.get('http://localhost:8080/api/airplanes') // Adjust API URL as needed
            .then(response => {
                setData(response.data);
            })
            .catch(error => {
                console.error("Error fetching data: ", error);
            });
    }, []);

    // Delete an item by ID
    const handleDelete = (id) => {
        axios.delete(`http://localhost:8080/api/airplanes/${id}`)
            .then(() => {
                // Remove the deleted item from the state
                setData(data.filter(item => item.id !== id));
                alert("Item deleted successfully");
            })
            .catch(error => {
                console.error("Error deleting item: ", error);
            });
    };

    return (
        <div>
            <h2>Delete Data</h2>
            <table border="1">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Airplane Name</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                {data.map((item) => (
                    <tr key={item.id}>
                        <td>{item.id}</td>
                        <td>{item.airplaneName}</td>
                        <td>
                            <button onClick={() => handleDelete(item.id)}>Delete</button>
                        </td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
};

export default CityDeleteData;
