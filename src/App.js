import React, { useState } from "react";
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom'
import Home from "./components/pages/Home";
import Navbar from "./components/pages/Navbar";
import Login from "./components/pages/Login";
import Footer from "./components/pages/Footer";
import Registerprovider from "./components/pages/Registerprovider";

import Register1 from "./components/pages/Register1";



function App() {
 const xyz=localStorage.getItem('user')
 const [Demo, setDemo] = useState(xyz)
 
 function loginHandler(){
  setDemo(!Demo)
  }

  return (
 
 <Router>
      <div>
        <Navbar login={loginHandler} status={xyz}/>
        <Switch>
      
          <Route exact path="/" component={Home} />
          <Route path="/login" component={Login} />
          <Route path="/register" component={Register1} />
          <Route path="/registerprovider" component={Registerprovider} />
          {/* <Route path="/home" component={ HomePage } />  */}
        </Switch>
        <Footer /> 
      </div>
    </Router>

  );
}

export default App;
