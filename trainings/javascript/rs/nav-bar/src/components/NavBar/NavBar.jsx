import * as FaIcons from "react-icons/fa"
import * as AiIcons from "react-icons/ai"
import {Link} from "react-router-dom"
import { useState } from "react"
import { SideBarData } from "./SideBarData"
import "./NavBar.css"
import { IconContext } from "react-icons"

export default function NavBar(){
    const [sidebar, setSideBar] = useState(false)
    const showSideBar = () => setSideBar(!sidebar)
    return(
        <>
        <IconContext.Provider value={{color:'#fff'}}>
            <div className="navbar">
                <Link to="#" className="menu-bars">
                    <FaIcons.FaBars onClick={showSideBar}/>
                </Link>
            </div>
            <nav className={sidebar ? 'nav-menu active' : 'nav-menu'}>
                <ul className="nav-menu-items"  >
                    <li className="navbar-toggle">
                    <Link to="#" className="menu-bars">
                        <AiIcons.AiOutlineClose onClick={showSideBar}/>
                    </Link>
                    </li>
                    {SideBarData.map((item, index)=>{
                        return (
                            <li key={index} className={item.cName}>
                                <Link to={item.path} onClick={showSideBar}>
                                    {item.icon}
                                    <span>{item.title}</span>
                                </Link>
                            </li>
                        )
                    })}
                </ul>
            </nav>
            </IconContext.Provider>
        </>
    );
}