export const getCarImage = (imgLink: string) => {
    let carImg ="";
    if (process.env.NODE_ENV === 'production') {
        carImg = `http://adve.info.uqam.ca/img/${imgLink}`;
    }
    else{
        let imgContext = require.context("../assets/images/", true);
        carImg = imgContext(`./${imgLink}`);
    }
    return carImg;
}