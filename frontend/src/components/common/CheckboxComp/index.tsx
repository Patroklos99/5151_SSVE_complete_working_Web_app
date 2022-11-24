import { ClassNames } from '@emotion/react';
import FormControlLabel  from '@mui/material/FormControlLabel';
import React from 'react';
import FormGroup from '@mui/material/FormGroup';
import Checkbox from '@mui/material/Checkbox';


export default function CheckboxComp( brand: any, changeChecked: any): any {

    return (
        <FormGroup>
            <FormControlLabel control={<Checkbox defaultChecked />} label="Porsche" />
            <FormControlLabel control={<Checkbox defaultChecked />} label="Tesla" />
            <FormControlLabel control={<Checkbox defaultChecked />} label="Bmw" />

        </FormGroup>
    );
}