import axios from 'axios'
import { React, useState, useEffect }  from 'react'
import { Link } from 'react-router-dom'


import '../../App.css'


export default function Login() {




        const [username, setUsername] = useState("");
        const [password, setPassword] = useState("");
        const [user, setUser] = useState();
      
        useEffect(() => {
          const loggedInUser = localStorage.getItem("user");
          if (loggedInUser) {
            const foundUser = JSON.parse(loggedInUser);
            setUser(foundUser);
          }
        }, []);
      
        // logout the user
        const handleLogout = () => {
          setUser({});
          setUsername("");
          setPassword("");
          localStorage.clear();
        };
      
        // login the user
        const handleSubmit = async e => {
          e.preventDefault();
          const user = { username, password };
          // send the username and password to the server
          const response = await axios.post(
            "https://jsonplaceholder.typicode.com/posts",
            user
          );
          // set the state of the user
          setUser(response.data);
          // store the user in localStorage
          localStorage.setItem("user", JSON.stringify(response.data));
        };
      
        // if there's a user show the message below
        if (user) {
          return (
            <div>
                
              {user.name} is loggged in
              <button onClick={handleLogout}>logout</button>
            </div>
           
          );
        }

    // const form = (e) => {

    //     e.preventDefault()

    //     const username = e.target.first_name.value
    //     const password = e.target.password.value

    //     axios.post ("https://jsonplaceholder.typicode.com/posts", {
    //         username,password})
    //         .then((response) => {
    //             console.log(response)
    //         })
    //         .catch(error => {
    //             console.log(error)
    //         })
    //     }
    
        








    return (
        <div className="text-center m-5-auto">
            <h2>Sign in to us</h2>
            <form onSubmit={handleSubmit} >
                <p>
                    <label>Username or email address</label><br/>
                    {/* <input id="id1" type="text" name="first_name" required /> */}
                    <input
          type="text"
          value={username}
          placeholder="enter a username"
          onChange={({ target }) => setUsername(target.value)}
        />
                </p>
                <p>
                    <label>Password</label>
                    <Link to="/forget-password"><label className="right-label">Forget password?</label></Link>
                    <br/>
                    {/* <input id= "id2" type="password" name="password" required /> */}
                    <input
            type="password"
            value={password}
            placeholder="enter a password"
            onChange={({ target }) => setPassword(target.value)}
          />
                </p>
                <p>
                    <button id="sub_btn" type="submit">Login</button>
                </p>
            </form>
            <footer>
                <p>First time? <Link to="/register">Create an account</Link>.</p>
                <p><Link to="/">Back to Homepage</Link>.</p>
            </footer>
        </div>
       
        
    )
}

