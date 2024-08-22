import {Link} from "react-router-dom"
import {MenuList} from "./HeaderData"
import "./Header.css"
import { useState } from "react"
import { useEffect } from "react"

export default function Header(){
    
            return (
                <div className="header">
                <ul>
                    {MenuList.map(
                        (item, index)=>{
                            return(
                                <li key={index} className={item.className}>
                                    <p className="header-item"><Link to={item.path}>
                                        {item.title}
                                    </Link></p>
                                </li>
                            )
                        }
                    )}
                </ul>
            </div>
      );   
   }