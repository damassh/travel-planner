import {
    Dialog,
    DialogActions,
    DialogContent,
    DialogContentText,
    DialogTitle,
    TextField,
    makeStyles,
    useMediaQuery,
    useTheme
} from '@material-ui/core'
import { useState } from "react";
import Controls from "./controls/Controls";

const useStyles = makeStyles( theme => ({
    pageContent: {
        margin: theme.spacing(3),
        padding: theme.spacing(1)
    }
}))


const ItineraryFormDialog = (props) => {
    const classes = useStyles();
    const theme = useTheme();
    const fullScreen = useMediaQuery(theme.breakpoints.down('md'));

    const [open, setOpen] = useState(false);
    const {dialogTitle, dialogContentText} = props

    const handleClickOpen = () => {
        setOpen(true);
    };

    const handleClose = () => {
        setOpen(false);
    };

    return(
        <div className={classes.pageContent}>
            <Controls.Button
                type="submit"
                text="Save Itinerary"
                onClick={handleClickOpen}
            />
            <Dialog
                open={open}
                onClose={handleClose}
                aria-labelledby="form-dialog-title"
                fullScreen={fullScreen}
            >
                <DialogTitle id="form-dialog-title">
                    {dialogTitle}
                </DialogTitle>
                <DialogContent>
                    <DialogContentText>
                        {dialogContentText}
                    </DialogContentText>
                </DialogContent>
                <TextField
                    autoFocus
                    margin="dense"
                    id="itineraryName"
                    label="Itinerary Name"
                    type="input"
                    fullWidth
                />
                <DialogActions>
                    <Controls.Button
                        type="submit"
                        text="Save"
                        onClick={() => { alert('Save Itinerary') }}
                    />
                    <Controls.Button
                        text="Cancel"
                        color="default"
                        onClick={() => { alert('Save Itinerary') }}
                    />
                </DialogActions>
            </Dialog>
        </div>
    )
}

export default ItineraryFormDialog