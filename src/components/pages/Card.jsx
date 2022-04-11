import React from 'react'
import ac from '../images/ac.jpg'
function Card(props) {
    return (
        <div className='services'>

<div class="card" style={{ width: '18rem' }} >
  <img src={props.src} class="card-img-top" alt="..."/>
  <div class="card-body">
    <h5 class="card-title">{props.title}</h5>
    
    <p class="card-text">{props.text}</p>
    <button id="sub_btn" type="submit">Book</button>
  </div>
 
</div>

        </div>
    )
}

export default Card