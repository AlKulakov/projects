import React from 'react'
import "./Button.css"
import {Link} from "react-router-dom"

export default function Button({children, address}) {
  return (
    <>
        <Link to={address} className="moreButton">
          <p>{children} </p>
        </Link>
    </>
  )
}