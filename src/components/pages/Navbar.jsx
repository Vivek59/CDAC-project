import React from 'react'

import '../../../node_modules/bootstrap/dist/css/bootstrap.min.css'
const Navbar = (props) => {
  return (
    <div>

<section>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container">
    <a class="navbar-brand" href="/">DOOR-SERV</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="/">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/registerprovider">RegisterAsSeviceProvider</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/Login" onClick={props.login}>
            {props.status ? "logout" : "login"}
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/register">Signup</a>
        </li>
      </ul>
     </div>
  </div>
</nav>
</section>

    </div>
  )
}

export default Navbar