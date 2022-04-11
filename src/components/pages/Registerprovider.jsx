import React, { useState } from 'react'
import axios from 'axios'

function Registerprovider() {


  
  
      
      const [user, setUser] = useState({
        sname: '',
        username: '',
        password: '',
        cphone: '',
        staddress: '',
        areapin: '',
        cityname: '',
        scode:0,
        spin1:'',
        spin2:'',
        spin3:'',
        spin4:'' 
      })

  const { sname, username, password, cphone, staddress, areapin, cityname,scode,spin1,spin2,spin3,spin4} = user

  const changeHandler = e => {
    setUser({ ...user, [e.target.name]: e.target.value })
  }



  const submitHandler = async e => {
    e.preventDefault()


   const response = await axios.post("https://jsonplaceholder.typicode.com/posts", user
    )
      console.log(response)
  }



  return (



    
      <div className="text-center m-5-auto">
        <form onSubmit={e => submitHandler(e)}>
          <div class="form-group">
            <label for="exampleInputEmail1">Name</label>
            <input type="text" class="form-control" placeholder="Enter name" value={sname} name="sname" onChange={e => changeHandler(e)} />
          </div>

          <div class="form-group">
            <label for="exampleInputEmail1">User Name</label>
            <input type="text" class="form-control" placeholder="Enter name" value={username} name="username" onChange={e => changeHandler(e)} />

          </div>


          <div class="form-group">
            <label for="exampleInputPassword1">Password</label>
            <input type="password" class="form-control" placeholder="Password" value={password} name="password" onChange={e => changeHandler(e)} />
          </div>

          <div class="form-group"  >
            <label for="exampleInputEmail1">phone no</label>
            <input type="text" class="form-control" placeholder="enter ph no " value={cphone} name="cphone" onChange={e => changeHandler(e)} />

          </div>


          <div class="form-group">
            <label for="exampleInputEmail1">address</label>
            <input type="text" class="form-control" placeholder="address" value={staddress} name="staddress" onChange={e => changeHandler(e)} />

          </div>

          

          <div class="form-group">
            <label for="exampleInputEmail1">Area Pin</label>
            <input type="text" class="form-control" placeholder="Pin" value={areapin} name="areapin" onChange={e => changeHandler(e)} />

          </div>
          <div class="form-group">
            <label for="exampleInputEmail1">City Name</label>
            <input type="text" class="form-control" placeholder="City name" value={cityname} name="cityname" onChange={e => changeHandler(e)} />

          </div>
            <br></br>
            <br></br>
          <p>101-Plumber, 102-Carpenter, 103-Pest Control, 104-Electrician, 105-A/C Service </p>

          <div class="col-md-3">
            
            <label for="validationCustom04" class="form-label">Service code</label>
    
            <select class="form-select" id="validationCustom04" required name='scode' value={scode} onChange={e=>changeHandler(e)}>
              <option >Choose...</option>
              {/* selected disabled value="choose" */}
              <option >101</option>
              <option >102</option>
              <option>103</option>
              <option>104</option>
              <option>105</option>
            </select>
          </div>


          <div class="form-group">
            <label for="exampleInputEmail1">Service area pin 1</label>
            <input type="text" class="form-control" placeholder="" value={spin1} name="spin1" onChange={e => changeHandler(e)} />

          </div>
          
          <div class="form-group">
            <label for="exampleInputEmail1">Service area pin 2</label>
            <input type="text" class="form-control" placeholder="" value={spin2} name="spin2" onChange={e => changeHandler(e)} />

          </div>

          <div class="form-group">
            <label for="exampleInputEmail1">Service area pin 3</label>
            <input type="text" class="form-control" placeholder="" value={spin3} name="spin3" onChange={e => changeHandler(e)} />

          </div>

          <div class="form-group">
            <label for="exampleInputEmail1">Service area pin 4</label>
            <input type="text" class="form-control" placeholder="" value={spin4} name="spin4" onChange={e => changeHandler(e)} />

          </div>




          <button type="submit" id="sub_btn">Submit</button>
        </form>



      </div>
      
     
  )
}

export default Registerprovider





























// import React from 'react'

// const Registerprovider = () => {
//   return (
//     <div>

// <section class="h-100 bg-dark">
//   <div class="container py-5 h-100">
//     <div class="row d-flex justify-content-center align-items-center h-100">
//       <div class="col">
//         <div class="card card-registration my-4">
//           <div class="row g-0">
//             {/* <div class="col-xl-6 d-none d-xl-block">
//               <img
//                 src=""
//                 alt="Sample photo"
//                 class="img-fluid"
//                 style="border-top-left-radius: .25rem; border-bottom-left-radius: .25rem;"
//               />
//             </div> */}
//             <div class="col-xl-6">
//               <div class="card-body p-md-5 text-black">
//                 <h3 class="mb-5 text-uppercase">Registration</h3>

//                 {/* <div class="row">
//                   <div class="col-md-6 mb-4"> */}
//                   <div class="form-outline mb-4">
//                   <input type="text" id="form3Example" class="form-control form-control-lg" />
//                   <label class="form-label" for="form3Example8">Name</label>
//                 </div>
//                   {/* </div> */}
//                   {/* <div class="col-md-6 mb-4">
//                     <div class="form-outline">
//                       <input type="text" id="form3Example1n" class="form-control form-control-lg" />
//                       <label class="form-label" for="form3Example1n">Last name</label>
//                     </div>
//                   </div> */}
//                 {/* </div> */}

//                 <div class="row">
//                   <div class="col-md-6 mb-4">
//                     <div class="form-outline">
//                       <input type="text" id="form3Example1m1" class="form-control form-control-lg" />
//                       <label class="form-label" for="form3Example1m1">User Name</label>
//                     </div>
//                   </div>
//                   <div class="col-md-6 mb-4">
//                     <div class="form-outline">
//                       <input type="text" id="form3Example1n1" class="form-control form-control-lg" />
//                       <label class="form-label" for="form3Example1n1">Password</label>
//                     </div>
//                   </div>
//                 </div>

//                 <div class="form-outline mb-4">
//                   <input type="text" id="form3Example8" class="form-control form-control-lg" />
//                   <label class="form-label" for="form3Example8">Address</label>
//                 </div>

//                 {/* <div class="d-md-flex justify-content-start align-items-center mb-4 py-2">

//                   <h6 class="mb-0 me-4">Gender: </h6>

//                   <div class="form-check form-check-inline mb-0 me-4">
//                     <input
//                       class="form-check-input"
//                       type="radio"
//                       name="inlineRadioOptions"
//                       id="femaleGender"
//                       value="option1"
//                     />
//                     <label class="form-check-label" for="femaleGender">Female</label>
//                   </div>

//                   <div class="form-check form-check-inline mb-0 me-4">
//                     <input
//                       class="form-check-input"
//                       type="radio"
//                       name="inlineRadioOptions"
//                       id="maleGender"
//                       value="option2"
//                     />
//                     <label class="form-check-label" for="maleGender">Male</label>
//                   </div>

//                   <div class="form-check form-check-inline mb-0">
//                     <input
//                       class="form-check-input"
//                       type="radio"
//                       name="inlineRadioOptions"
//                       id="otherGender"
//                       value="option3"
//                     />
//                     <label class="form-check-label" for="otherGender">Other</label>
//                   </div>

//                 </div> */}

                

//                   <div class="form-outline mb-4">
//                   <input type="text" id="form3Example9" class="form-control form-control-lg" />
//                   <label class="form-label" for="form3Example9">City</label>
                
//                   </div>
//                   {/* <div class="col-md-6 mb-4">

//                     <select class="select">
//                       <option value="1">City</option>
//                       <option value="2">Option 1</option>
//                       <option value="3">Option 2</option>
//                       <option value="4">Option 3</option>
//                     </select>

//                   </div> */}
                

//                 <div class="form-outline mb-4">
//                   <input type="text" id="form3Example9" class="form-control form-control-lg" />
//                   <label class="form-label" for="form3Example9">Mobile No</label>
//                 </div>

//                 <div class="form-outline mb-4">
//                   <input type="text" id="form3Example90" class="form-control form-control-lg" />
//                   <label class="form-label" for="form3Example90">Pincode</label>
//                 </div>

//                 {/* <div class="form-outline mb-4">
//                   <input type="text" id="form3Example99" class="form-control form-control-lg" />
//                   <label class="form-label" for="form3Example99">Course</label>
//                 </div> */}

//                 <div class="form-outline mb-4">
//                   <input type="text" id="form3Example97" class="form-control form-control-lg" />
//                   <label class="form-label" for="form3Example97">Email ID</label>
//                 </div>

//                 <div class="d-flex justify-content-end pt-3">
//                   <button type="button" class="btn btn-light btn-lg">Reset all</button>
//                   <button type="button" class="btn btn-warning btn-lg ms-2">Submit form</button>
//                 </div>

//               </div>
//             </div>
//           </div>
//         </div>
//       </div>
//     </div>
//   </div>
// </section>

//     </div>
//   )
// }

// export default Registerprovider