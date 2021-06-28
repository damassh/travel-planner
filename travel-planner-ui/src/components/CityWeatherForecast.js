import KeyboardArrowDownIcon from '@material-ui/icons/KeyboardArrowDown';
import KeyboardArrowUpIcon from '@material-ui/icons/KeyboardArrowUp';
import Paper from '@material-ui/core/Paper';
import Typography from '@material-ui/core/Typography';
import WeatherForecast from "./WeatherForecast";
import { makeStyles } from '@material-ui/core/styles';
import { Table, TableHead, TableRow, TableBody, TableCell, Collapse, Box, IconButton } from '@material-ui/core';
import { useState, Fragment } from "react";
import Controls from "../components/controls/Controls";
import ItineraryFormDialog from "./ItineraryFormDialog";

const useStyles = makeStyles(theme => ({
    pageContent: {
        margin: theme.spacing(5),
        padding: theme.spacing(3)
    }
}))

const useRowStyles = makeStyles({
    root: {
        '& > *': {
            borderBottom: 'unset',
        },
    },
})

const Row = (props) => {
    const { row } = props;
    const [open, setOpen ] = useState(false);
    const classes = useRowStyles();

    return (
        <Fragment key={row.id}>
            <TableRow className={classes.root}>
                <TableCell>
                    <IconButton aria-label="expand row" size="small" onClick={() => setOpen(!open)}>
                        {open ? <KeyboardArrowUpIcon /> : <KeyboardArrowDownIcon />}
                    </IconButton>
                </TableCell>
                <TableCell>{row.cityName}</TableCell>
                <TableCell>{row.countryCode}</TableCell>
            </TableRow>
            <TableRow>
                <TableCell style={{ paddingBottom: 0, paddingTop: 0 }} colSpan={6}>
                    <Collapse in={open} timeout="auto" unmountOnExit>
                        <Box margin={1}>
                            <Typography variant="h6" gutterBottom component="div">
                                Forecast
                            </Typography>
                            <WeatherForecast row={row.weatherForecasts}/>
                        </Box>
                    </Collapse>
                </TableCell>
            </TableRow>
        </Fragment>
    )
}

const CityWeatherForecast = ({ cityWeatherForecasts }) => {
    const classes = useStyles();

    return(
        <Paper className={classes.pageContent}>
            <Typography variant="h6">Result</Typography>
            <Table>
                <TableHead>
                    <TableRow>
                        <TableCell/>
                        <TableCell>City</TableCell>
                        <TableCell>Country Code</TableCell>
                    </TableRow>
                </TableHead>
                <TableBody>
                    {cityWeatherForecasts.map((city) => (
                        <Row key={city.id} row={city}></Row>
                    ))}
                </TableBody>
            </Table>
        </Paper>
    )
}

export default CityWeatherForecast