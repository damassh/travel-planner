import PropTypes from 'prop-types'
import {Table, TableBody, TableCell, TableHead, TableRow} from "@material-ui/core"

const WeatherForecast = ( {row} ) => {

    const columnHeader=['Date', 'Temperature', 'Clouds']

    return(
        <Table size="small" aria-label="purchases">
            <TableHead>
                <TableRow>
                    {columnHeader.map((header) => (
                        <TableCell key={header} align="right">{header}</TableCell>
                    ))}
                </TableRow>
            </TableHead>
            <TableBody>
                {row.map((forecast) => (
                    <TableRow key={forecast.id}>
                        <TableCell component='th' scope='row' align='right'>{forecast.date}</TableCell>
                        <TableCell align="right">{forecast.temperature}</TableCell>
                        <TableCell align="right">{forecast.cloud}</TableCell>
                    </TableRow>
                ))}
            </TableBody>
        </Table>
    )
}

WeatherForecast.propTypes = {
    row: PropTypes.arrayOf(
        PropTypes.shape({
            temperature: PropTypes.number.isRequired,
            cloud: PropTypes.number.isRequired,
    }))
}

export default WeatherForecast