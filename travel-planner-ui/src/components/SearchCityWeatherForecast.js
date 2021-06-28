import { useState, useEffect } from "react";
import {Grid, Typography} from '@material-ui/core';
import Controls from "../components/controls/Controls";
import { UseForm, Form } from './Form';
import { Paper, makeStyles } from '@material-ui/core';

const useStyles = makeStyles(theme => ({
    pageContent: {
        margin: theme.spacing(5),
        padding: theme.spacing(3)
    }
}))

const initialFValues = {
    cityName: '',
    startDate: null,
    endDate: null
}

const convertDateToString = (date) => {
    let newDate = new Date(date)
    let dateStr =  (newDate.getFullYear() + '-'
                    + ('0' + (newDate.getMonth() + 1)).slice(-2) + '-'
                    + ('0' + newDate.getDate()).slice(-2))
    return dateStr
}

const SearchCityWeatherForecast = ( { fetchWeatherForecast }) => {

    const classes = useStyles();

    const validate = (fieldValues = values) => {
        let temp = { ...errors }
        if ('cityName' in fieldValues)
            temp.cityName = fieldValues.cityName ? "" : "This field is required."
        if ('startDate' in fieldValues)
            temp.startDate = fieldValues.startDate ? "" : "This field is required."
        if ('endDate' in fieldValues)
            temp.endDate = fieldValues.endDate ? "" : "This field is required."
        setErrors({
            ...temp
        })
        if (fieldValues === values)
            return Object.values(temp).every(x => x === "")
    }

    const {
        values,
        setValues,
        errors,
        setErrors,
        handleInputChange,
        resetForm
    } = UseForm(initialFValues, true, validate);

    const handleSubmit = e => {
        e.preventDefault()
        if(validate()) {
            const cityName = values.cityName
            const startDate = convertDateToString(values.startDate)
            const endDate = convertDateToString(values.endDate)
            fetchWeatherForecast({ cityName, startDate, endDate })
            resetForm()
        }
    }
    return(
        <Paper className={classes.pageContent}>
            <Form onSubmit={handleSubmit}>
                <Typography variant="h6">Search City Weather Forecast</Typography>
                <Grid container>
                    <Grid item xs={6}>
                        <Controls.Input
                            name='cityName'
                            label='City'
                            value={values.cityName}
                            onChange={handleInputChange}
                            error={errors.cityName}
                        />
                    </Grid>
                    <Grid item xs={6}>
                        <Controls.DatePicker
                            name='startDate'
                            label='Start Date'
                            value={values.startDate}
                            disablePast='true'
                            onChange={handleInputChange}
                            error={errors.startDate}
                        />
                        <Controls.DatePicker
                            name='endDate'
                            label='End Date'
                            value={values.endDate}
                            minDate={values.startDate}
                            disablePast='true'
                            minDateMessage='Date should be before start date'
                            onChange={handleInputChange}
                            error={errors.endDate}
                        />
                        <div>
                            <Controls.Button
                                type="submit"
                                text="Submit" />
                            <Controls.Button
                                text="Reset"
                                color="default"
                                onClick={resetForm} />
                        </div>
                    </Grid>
                </Grid>
            </Form>
        </Paper>
    )
}

export default SearchCityWeatherForecast