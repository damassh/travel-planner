import {Modal as MuiModal, makeStyles } from "@material-ui/core";
import {useState} from "react";



function rand() {
    return Math.round(Math.random() * 20) - 10;
}

function getModalStyle() {
    const top = 50 + rand();
    const left = 50 + rand();

    return {
        top: `${top}%`,
        left: `${left}%`,
        transform: `translate(-${top}%, -${left}%)`,
    };
}

const useStyles = makeStyles((theme) => ({
    paper: {
        position: 'absolute',
        width: 400,
        backgroundColor: theme.palette.background.paper,
        border: '2px solid #000',
        boxShadow: theme.shadows[5],
        padding: theme.spacing(2, 4, 3),
    },
}));

const Modal = (props) => {
    const classes = useStyles();
    const [modalStyle] = useState(getModalStyle)
    const [open, setOpen] = useState(false);

    const handleOpen = () => {
        setOpen(true);
    };

    const handleClose = () => {
        setOpen(false);
    };

    const bodyContent = ({ title, description, body }) => {
        return(
            <div style={modalStyle} className={classes.paper}>
                <h2></h2>
            </div>
        )
    }

    const { title , description, body } = props
    return(
        <MuiModal
            open={open}
            onClose={handleClose}
            aria-labelledby="simple-modal-title"
            aria-describedby="simple-modal-description"
        >
            Hello
        </MuiModal>

    )
}

export default Modal