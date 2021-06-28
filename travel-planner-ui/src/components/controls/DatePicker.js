import { MuiPickersUtilsProvider, KeyboardDatePicker } from '@material-ui/pickers';
import DateFnsUtils from '@date-io/date-fns';


const DatePicker = (props) => {
    const FORMAT = 'yyyy-MM-dd'
    const { name, label, value, minDate, maxDate,
        minDateMessage, disablePast, onChange, error=null } = props

    const convertToDefEventPara = (name, value) => ({
        target: {
            name, value
        }
    })

    return(
        <MuiPickersUtilsProvider utils={DateFnsUtils} >
            <KeyboardDatePicker
                disableToolbar
                variant='inline'
                inputVariant='outlined'
                label={label}
                format={FORMAT}
                name={name}
                value={value}
                minDate={minDate}
                minDateMessage={minDateMessage}
                maxDate={maxDate}
                disablePast={disablePast}
                placeholder={FORMAT}
                onChange={date =>onChange(convertToDefEventPara(name,date))}
                {...(error && {error:true,helperText:error})}
            />
        </MuiPickersUtilsProvider>
    )
}

export default DatePicker