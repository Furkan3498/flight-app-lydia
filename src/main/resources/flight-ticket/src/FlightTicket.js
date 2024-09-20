import React, { useState } from 'react';
import './AdminPanel.css'; // Assuming you have the CSS here

// Country related imports
import CountryPostForm from "./country/CountryPostForm";
import CountryUpdateForm from "./country/CountryUpdateForm";
import CountryFetchData from "./country/CountryGetForm";
import CountryDeleteForm from "./country/CountryDeleteForm";

// City related imports
import CityPostForm from "./city/CityPostForm";
import CityDeleteData from "./city/CityDeleteForm";
import CityFetchData from "./city/CityGetForm";
import CityUpdateForm from "./city/CityUpdateForm";

// Address related imports
import AddressPostForm from "./address/AddressPostForm";
import AddressDeleteData from "./address/AddressDeleteForm";
import AddressFetchData from "./address/AddressGetForm";
import AddressUpdateForm from "./address/AddressUpdateForm";

// AirlineCompany related imports
import AirlineCompanyPostForm from "./airlineCompany/AirlineCompanyPostForm";
import AirlineCompanyDeleteForm from "./airlineCompany/AirlineCompanyDeleteForm";
import AirlineCompanyFetchData from "./airlineCompany/AirlineCompanyGetForm";
import AirlineCompanyUpdateForm from "./airlineCompany/AirlineCompanyUpdateForm";

// Airplane related imports
import AirplanePostForm from "./airplane/AirplanePostForm";
import AirplaneDeleteForm from "./airplane/AirplaneDeleteForm";
import AirplaneGetForm from "./airplane/AirplaneGetForm";
import AirplaneUpdateForm from "./airplane/AirplaneUpdateForm";

// Airport related imports
import AirportPostForm from "./airport/AirportPostForm";
import AirportDeleteData from "./airport/AirportDeleteForm";
import AirportGetForm from "./airport/AirportGetForm";
import AirportUpdateForm from "./airport/AirportUpdateForm";

// Flight related imports
import FlightPostForm from "./flight/FlightPostForm";
import FlightDeleteForm from "./flight/FlightDeleteForm";
import FlightGetForm from "./flight/FlightGetForm";
import FlightUpdateForm from "./flight/FlightUpdateForm";

// Pilot related imports
import PilotPostForm from "./pilot/PilotPostForm";
import PilotDeleteForm from "./pilot/PilotDeleteForm";
import PilotGetForm from "./pilot/PilotGetForm";
import PilotUpdateForm from "./pilot/PilotUpdateForm";

// Rotation related imports
import RotationPostForm from "./rotation/RotationPostForm";
import RotationDeleteData from "./rotation/RotationDeleteForm";
import RotationGetForm from "./rotation/RotationGetForm";
import RotationUpdateForm from "./rotation/RotationUpdateForm";

// TicketBooking related imports
import TicketBookingPostForm from "./ticketBooking/TicketBookingPostForm";
import TicketBookingDeleteData from "./ticketBooking/TicketBookingDeleteForm";
import TicketBookingFetchData from "./ticketBooking/TicketBookingGetForm";
import TicketBookingUpdateForm from "./ticketBooking/TicketBookingUpdateForm";

// TicketPrice related imports
import TicketPricePostForm from "./ticketPrice/TicketPricePostForm";
import TicketPriceDeleteData from "./ticketPrice/TicketPriceDeleteForm";
import TicketPriceFetchData from "./ticketPrice/TicketPriceGetForm";
import TicketPriceUpdateForm from "./ticketPrice/TicketPriceUpdateForm";
const AdminPanel = () => {
    const [activeComponent, setActiveComponent] = useState('countryPost');

    // Object to map activeComponent states to actual components
    const componentMap = {
        countryPost: <CountryPostForm />,
        countryUpdate: <CountryUpdateForm />,
        countryFetch: <CountryFetchData />,
        countryDelete: <CountryDeleteForm />,
        cityPost: <CityPostForm />,
        cityDelete: <CityDeleteData />,
        cityFetch: <CityFetchData />,
        cityUpdate: <CityUpdateForm />,
        addressPost: <AddressPostForm />,
        addressDelete: <AddressDeleteData />,
        addressFetch: <AddressFetchData />,
        addressUpdate: <AddressUpdateForm />,
        airlineCompanyPost: <AirlineCompanyPostForm />,
        airlineCompanyDelete: <AirlineCompanyDeleteForm />,
        airlineCompanyFetch: <AirlineCompanyFetchData />,
        airlineCompanyUpdate: <AirlineCompanyUpdateForm />,
        airplanePost: <AirplanePostForm />,
        airplaneDelete: <AirplaneDeleteForm />,
        airplaneFetch: <AirplaneGetForm />,
        airplaneUpdate: <AirplaneUpdateForm />,
        airportPost: <AirportPostForm />,
        airportDelete: <AirportDeleteData />,
        airportFetch: <AirportGetForm />,
        airportUpdate: <AirportUpdateForm />,
        flightPost: <FlightPostForm />,
        flightDelete: <FlightDeleteForm />,
        flightFetch: <FlightGetForm />,
        flightUpdate: <FlightUpdateForm />,
        pilotPost: <PilotPostForm />,
        pilotDelete: <PilotDeleteForm />,
        pilotFetch: <PilotGetForm />,
        pilotUpdate: <PilotUpdateForm />,
        rotationPost: <RotationPostForm />,
        rotationDelete: <RotationDeleteData />,
        rotationFetch: <RotationGetForm />,
        rotationUpdate: <RotationUpdateForm />,
        ticketBookingPost: <TicketBookingPostForm />,
        ticketBookingDelete: <TicketBookingDeleteData />,
        ticketBookingFetch: <TicketBookingFetchData />,
        ticketBookingUpdate: <TicketBookingUpdateForm />,
        ticketPricePost: <TicketPricePostForm />,
        ticketPriceDelete: <TicketPriceDeleteData />,
        ticketPriceFetch: <TicketPriceFetchData />,
        ticketPriceUpdate: <TicketPriceUpdateForm />,
    };

    return (
        <div className="admin-container">
            {/* Left-side navbar */}
            <nav className="sidebar">
                <ul>
                    <h2>Country</h2>
                    <li onClick={() => setActiveComponent('countryPost')}>Create Country</li>
                    <li onClick={() => setActiveComponent('countryUpdate')}>Update Country</li>
                    <li onClick={() => setActiveComponent('countryFetch')}>Get All Countries</li>
                    <li onClick={() => setActiveComponent('countryDelete')}>Delete Country</li>
                    <hr />
                    <h2>City</h2>
                    <li onClick={() => setActiveComponent('cityPost')}>Create City</li>
                    <li onClick={() => setActiveComponent('cityDelete')}>Delete City</li>
                    <li onClick={() => setActiveComponent('cityFetch')}>Get All Cities</li>
                    <li onClick={() => setActiveComponent('cityUpdate')}>Update City</li>
                    <hr />
                    <h2>Address</h2>
                    <li onClick={() => setActiveComponent('addressPost')}>Create Address</li>
                    <li onClick={() => setActiveComponent('addressDelete')}>Delete Address</li>
                    <li onClick={() => setActiveComponent('addressFetch')}>Get All Addresses</li>
                    <li onClick={() => setActiveComponent('addressUpdate')}>Update Address</li>
                    <hr />
                    <h2>Airline Company</h2>
                    <li onClick={() => setActiveComponent('airlineCompanyPost')}>Create Airline Company</li>
                    <li onClick={() => setActiveComponent('airlineCompanyDelete')}>Delete Airline Company</li>
                    <li onClick={() => setActiveComponent('airlineCompanyFetch')}>Get All Airline Companies</li>
                    <li onClick={() => setActiveComponent('airlineCompanyUpdate')}>Update Airline Company</li>
                    <hr />
                    {/* Add remaining sidebar items similarly... */}
                </ul>
            </nav>

            {/* Main content area */}
            <div className="content">
                {componentMap[activeComponent] || <CountryPostForm />}
            </div>
        </div>
    );
};

export default AdminPanel;
