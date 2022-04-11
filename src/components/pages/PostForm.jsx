import axios from 'axios'
import React, { Component } from 'react'

 class PostForm extends Component {
     constructor(props) {
       super(props)
     
       this.state = {
          input1:'',
          input2:''
       }
     }

     changeHandler = e => {
         this.setState({[e.target.name]:e.target.value})
     }

     submitHandler = e => {
         e.preventDefault()
         console.log(this.state)
     
            axios.post("https://jsonplaceholder.typicode.com/posts",this.state
            )
            .then(response=>{
                console.log(response)
                console.log(this.state)

            })
            .catch(error=>{
                console.log(error)
            })
        }





  render() {
      const {input1,input2}=this.state
    return (
      <div>
          <form onSubmit={this.submitHandler}>
        
                <div class="mb-3">
                    <label for="formGroupExampleInput" class="form-label">Example label</label> 
                    <input name = "input1" type="text" class="form-control" id="formGroupExampleInput" placeholder="Example input placeholder" value={input1} onChange={this.changeHandler}/>
                </div>
                <div class="mb-3">
                    <label for="formGroupExampleInput2" class="form-label">Another label</label>
                    <input name = "input2" type="text" class="form-control" id="formGroupExampleInput2" placeholder="Another input placeholder" value={input2} onChange={this.changeHandler}/>
                </div>
                <div>
                <button type='submit'>submit</button>
                </div>
            </form>

        </div>
    )
  }
}

export default PostForm