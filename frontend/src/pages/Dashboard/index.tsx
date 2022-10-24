import React, { useEffect, useState } from 'react';
import FilterPanel from '../../components/Dashboard/FilterPanel';
import ResultCars from '../../components/Dashboard/ResultCars';
import './styles.css';


const Dashboard = () => {
    return (
        <div className='dashboard'>
            <div className='dashboard_panelResultCars-warp'>
                <div className='dashboard_filterPanel-warp'>
                    <FilterPanel />
                </div>
                <div className='dashboard_resultCars-warp'>
                    <ResultCars />
                </div>
            </div>
        </div>

    );
};

export default Dashboard;