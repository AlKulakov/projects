import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import NavBar from './components/NavBar/NavBar'
import './App.css'
import Home from './pages/Home'
import Reports from './pages/Reports'
import Products from './pages/Products'

import { BrowserRouter as Router, Routes as Switch, Route } from 'react-router-dom'
import BottomBar from './components/BottomBar/BottomBar'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
    <Router>
      <NavBar/>
      <Switch>
        <Route path='/' exact Component={Home} />
        <Route path='/reports' Component={Reports} />
        <Route path='/products' Component={Products} />
      </Switch>
    </Router>
    <BottomBar/>
    </>
  )
}

export default App
