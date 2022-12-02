import Image from '../../assets/logo.png'
import React from "react";
import './Logo.css'

const Logo: React.FC = () => {
    return(
      <div className="logoTitle">
        <img className='logo' src={Image} alt='not-found'/>
        <p className='title1'>SSVE</p>
      </div>
    )
  }

  export default Logo