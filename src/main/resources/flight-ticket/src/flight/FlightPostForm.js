import React, { useState, useEffect } from 'react';
import axios from 'axios';

const FlightPostForm = () => {
    const [formData, setFormData] = useState({
        flightCode: '',
        depatureTime: '',
        arrivalTime: '',
        rotationId: '',
        pilotId: '',
        companyId: '',
        airplaneId: '',
        ticketPriceId: ''
    });

    // API'den veri çekmek için state
    const [companies, setCompanies] = useState([]);
    const [pilots, setPilots] = useState([]);
    const [airplanes, setAirplanes] = useState([]);
    const [rotations, setRotations] = useState([]);

    // Şirketleri, pilotları ve uçakları API'den çek
    useEffect(() => {
        axios.get('http://localhost:8080/api/airlinecompanies')
            .then(response => setCompanies(response.data))
            .catch(error => console.error("Error fetching companies: ", error));

        axios.get('http://localhost:8080/api/rotations')
            .then(response => setRotations(response.data))
            .catch(error => console.error("Error fetching rotations: ", error));

        axios.get('http://localhost:8080/api/pilots')
            .then(response => setPilots(response.data))
            .catch(error => console.error("Error fetching pilots: ", error));

        axios.get('http://localhost:8080/api/airplanes')
            .then(response => setAirplanes(response.data))
            .catch(error => console.error("Error fetching airplanes: ", error));
    }, []);

    // Form submit işlemi
    const handleSubmit = (e) => {
        e.preventDefault();
        axios.post('http://localhost:8080/api/flights', formData)
            .then(response => {
                alert('Flight Created Successfully');
                setFormData({
                    flightCode: '',
                    depatureTime: '',
                    arrivalTime: '',
                    rotationId: '',
                    pilotId: '',
                    companyId: '',
                    airplaneId: '',
                    ticketPriceId: ''
                });
            })
            .catch(error => console.error("There was an error creating the flight!", error));
    };

    return (
        <div>
            <h2>Add New Flight</h2>
            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    placeholder="Flight Code"
                    value={formData.flightCode}
                    onChange={(e) => setFormData({ ...formData, flightCode: e.target.value })}
                />
                <input
                    type="date"
                    placeholder="Departure Time"
                    value={formData.depatureTime}
                    onChange={(e) => setFormData({ ...formData, depatureTime: e.target.value })}
                />
                <input
                    type="date"
                    placeholder="Arrival Time"
                    value={formData.arrivalTime}
                    onChange={(e) => setFormData({ ...formData, arrivalTime: e.target.value })}
                />
                <select
                    value={formData.rotationId}
                    onChange={(e) => setFormData({...formData, rotationId: e.target.value})}
                >
                    <option value="">Select Rotation</option>
                    {airplanes.map(rotation => (
                        <option key={rotation.id} value={rotation.id}>
                            {rotation.id}
                        </option>
                    ))}
                </select>

                {/* Pilot için ComboBox */}
                <select
                    value={formData.pilotId}
                    onChange={(e) => setFormData({...formData, pilotId: e.target.value})}
                >
                    <option value="">Select Pilot</option>
                    {pilots.map(pilot => (
                        <option key={pilot.id} value={pilot.id}>
                            {pilot.pilotFirstName + ' ' + pilot.pilotLastName}
                        </option>
                    ))}
                </select>

                {/* Şirket için ComboBox */}
                <select
                    value={formData.companyId}
                    onChange={(e) => setFormData({ ...formData, companyId: e.target.value })}
                >
                    <option value="">Select Company</option>
                    {companies.map(company => (
                        <option key={company.id} value={company.id}>
                            {company.companyName}
                        </option>
                    ))}
                </select>

                {/* Uçak için ComboBox */}
                <select
                    value={formData.airplaneId}
                    onChange={(e) => setFormData({ ...formData, airplaneId: e.target.value })}
                >
                    <option value="">Select Airplane</option>
                    {airplanes.map(airplane => (
                        <option key={airplane.id} value={airplane.id}>
                            {airplane.airplaneName}
                        </option>
                    ))}
                </select>

                <input
                    type="number"
                    placeholder="Ticket Price ID"
                    value={formData.ticketPriceId}
                    onChange={(e) => setFormData({ ...formData, ticketPriceId: e.target.value })}
                />
                <button type="submit">Submit</button>
            </form>
        </div>
    );
};

export default FlightPostForm;
