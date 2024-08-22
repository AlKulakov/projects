
import { BrowserRouter, Routes, Route} from 'react-router-dom'
import './App.css'
import Header from './components/Header/Header'
import Home from './components/Main/Home/Home'
import About from './components/Main/About/About'

export default function App() {
  return (
    <>
    <div className="myName">
      <p>Aleksandr Kulakov</p> 
      <p style={{fontWeight: "bold", color: "rgb(0, 151, 252)"}}>Developer</p>
    </div>
      <BrowserRouter>
        <Header/>
        <Routes>
          <Route path='/' element={<Home/>}/>
          <Route path='/about' element={<About/>}/>
        </Routes>
      </BrowserRouter>
    </>
  )
}
