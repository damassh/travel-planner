import Header from "./components/Header"
import CityWeatherForecast from "./components/CityWeatherForecast";
import SearchCityWeatherForecast from "./components/SearchCityWeatherForecast";
import {useState, useEffect} from "react";
import {makeStyles, CssBaseline, createMuiTheme, ThemeProvider, Typography, Paper} from '@material-ui/core'
import ItineraryFormDialog from "./components/ItineraryFormDialog";

const theme = createMuiTheme({
    palette: {
        primary: {
            main: "#333996",
            light: '#3c44b126'
        },
        secondary: {
            main: "#f83245",
            light: '#f8324526'
        },
        background: {
            default: "#f4f5fd"
        },
    },
    overrides:{
        MuiAppBar:{
            root:{
                transform:'translateZ(0)'
            }
        }
    },
    props:{
        MuiIconButton:{
            disableRipple:true
        }
    }
})

const useStyles = makeStyles({
    appMain: {
        width: '100%'
    },
    pageContent: {
        margin: theme.spacing(5),
        padding: theme.spacing(3)
    }
})

const App = () => {
    const classes = useStyles();


    const [cityWeatherForecasts, setCityWeatherForecasts] = useState([]);
    const [itineraries, setItineraries] = useState([]);


    const fetchWeatherForecast = async ( params ) => {
        const url = `/getWeatherForecastByCity?cityName=${params.cityName}&startDate=${params.startDate}&endDate=${params.endDate}`
        const res = await fetch(url);
        const data = await res.json()
        setCityWeatherForecasts([...cityWeatherForecasts, data])
    }

    const saveItinerary = async ( params ) => {
        const res = await fetch(`/saveItinerary`, {
            methods: 'POST',
            headers: {
                'Content-type': 'application/json'
            }, body: JSON.stringify(params)
        })
        const data = await res.json()
        setItineraries([...itineraries, data])
    }

    return(
        <ThemeProvider theme={theme}>
            <div className={classes.appMain}>
                <Header/>
                <SearchCityWeatherForecast fetchWeatherForecast={fetchWeatherForecast}/>
                {cityWeatherForecasts.length > 0 ?
                    (
                        <div>
                            <CityWeatherForecast cityWeatherForecasts={cityWeatherForecasts}/>
                            <ItineraryFormDialog
                                dialogTitle='Save Itinerary'
                                dialogContentText='Enter Itinerary Name'
                            />
                        </div>
                    ) : <Paper className={classes.pageContent}>
                        <Typography variant="h6">No Results</Typography>
                    </Paper>

                }

            </div>
            <CssBaseline />
        </ThemeProvider>
    )
}

export default App;
