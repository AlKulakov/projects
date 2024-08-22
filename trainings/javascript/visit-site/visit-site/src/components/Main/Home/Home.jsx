import "./Home.css"
import React from 'react'
import { FaTelegram } from "react-icons/fa";
import { IoLogoWhatsapp } from "react-icons/io";
import myPhoto from '/photo.jfif'
import Button from "../Button/Button"
import Footer from "../../Footer/Footer"

export default function Main() {
  return (
    <>
        <div className="container">
            <div className="main-inner">

                <div className="field">
                    <p>There is a piece of code</p>
                    <p>for <span style={{color: "rgb(0, 151, 252)"}}>any problem</span></p>
                    <Button address={"/discounts"}>Learn more</Button>
                </div>
                <img src={myPhoto} alt="" className="myImage" />
            </div>
            <div className="contIcons">
                <a href='https://t.me/vince6762' target="_blank"><FaTelegram /></a>
                <a target="_blank" href="https://wa.me/+79106792045"><IoLogoWhatsapp/></a>
        </div>
        </div>

    </>
  )
}
