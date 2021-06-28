import { Paper, Typography, makeStyles } from '@material-ui/core'

const useStyles = makeStyles(theme => ({
    root: {
        backgroundColor: '#fdfdff'
    },
    pageHeader:{
        padding:theme.spacing(4),
        display:'flex',
        marginBottom:theme.spacing(2)
    },
    pageTitle:{
        paddingLeft:theme.spacing(4),
        '& .MuiTypography-subtitle2':{
            opacity:'0.6'
        }
    }
}))

const Header = ({ title, subTitle }) => {
    const classes = useStyles();
    return (
        <Paper elevation={0} square className={classes.root}>
            <div className={classes.pageHeader}>
                <div className={classes.pageTitle}>
                    <Typography
                        variant="h6"
                        component="div">
                        {title}
                    </Typography>
                    <Typography
                        variant="subtitle2"
                        component="div">
                        {subTitle}
                    </Typography>
                </div>
            </div>
        </Paper>
    )
}

Header.defaultProps = {
    title: 'Travel Planner',
    subTitle: 'Search Weather Forecast'
}

export default Header