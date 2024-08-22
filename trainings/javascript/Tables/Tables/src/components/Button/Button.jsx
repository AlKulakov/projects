import React from 'react'
import "./Button.css"
export default function Button({children, isActive, onClickFunction}) {
  return (
        <button className={isActive ? "headerButton active" : "headerButton"} onClick={onClickFunction}>
            {children}
        </button>
  )
}
