import * as FaIcons from "react-icons/fa"
import * as AiIcons from "react-icons/ai"
import * as IoIcons from "react-icons/io"
import { IconContext } from "react-icons"

export const SideBarData = [
    
    {
        title:"Главная",
        path: "/",
        icon: <AiIcons.AiFillHome size={20}/>,
        cName: 'nav-text'
    },
    {
        title:"Обращения",
        path: "/reports",
        icon: <IoIcons.IoIosPaper  size={20}/>,
        cName: 'nav-text'
    },
    {
        title:"Продукты",
        path: "/products",
        icon: <FaIcons.FaCartPlus  size={20}/>,
        cName: 'nav-text'
    },
    {
        title:"Команда",
        path: "/team",
        icon: <IoIcons.IoMdPeople  size={20}/>,
        cName: 'nav-text'
    },
    {
        title:"Сообщения",
        path: "/messages",
        icon: <FaIcons.FaEnvelopeOpenText  size={20}/>,
        cName: 'nav-text'
    },
    {
        title:"Помощь",
        path: "/support",
        icon: <IoIcons.IoMdHelpCircle  size={20}/>,
        cName: 'nav-text'
    } 
]
