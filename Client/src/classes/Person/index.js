import React from 'react';

import './index.css';

class Person {
  constructor(name, aboutMe, picture) {
    this.aboutMe = aboutMe;
    this.name = name;
    this.picture = picture;

    
  }


  

  build = () => {

    return (
      <div class="aboutUsCard">    
      <img className="personImage" src={this.picture} alt={this.name}>
      
       </img>
          <h1 className = "name"> {this.name} </h1>

    <p className="aboutme"> {this.aboutMe}</p>
      </div>
    );
  }
}

export default Person;
