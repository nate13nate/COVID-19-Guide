import React from 'react';

import './index.css';
import Person from '../../classes/Person';
import boPicture from '../../images/bo.JPG';

import jaredPicture from '../../images/jared.png'
import jeremiahPicture from '../../images/jeremiah.jpg'
import natePicture from '../../images/nate.jpg'


import julienPicture from '../../images/julien.JPG';
class AboutUSPage extends React.Component {
  build = () => {
    // do stuff based off searchValue
    const results = [
      new Person('Nate Nading', 'I am a college junior working through my Computer Science degree. I am currently working as a Web Developer at NRCCUA.', natePicture),

      new Person('Julien Goolsby', 'I am a freshman studying Computer Science. During high school, I was an intern at Cerner through the Northland Caps program. I also know mobile technologies such as Flutter and Cordova as well as create games in Unity. In my free time, I also do music.', julienPicture),
    new Person('Bo Varvil', 'I am a senior, majoring in Software Engineering, minor in Mathematics. I have been an intern at SS&C Technologies. There I built a couple applications, one was a flaw tracking application. The other is a certificate tracking application. I also was able to work on a project for Commerce Bank', boPicture),
    new Person('Jared Clapp', 'My name is Jared Clapp. I am a junior at the University of Central Missouri studying Software Engineering. I have experience in java, html, and spring. In my free time I enjoy making Android applications.', jaredPicture),
    new Person('Jeremiah C', 'I am a junior at the University of Central Missouri, studying Computer Science, Software Development. I love to code and learn about development practices. I complete most of my personal in either Java or Javascript. When I am not coding, I like to run outdoors.', jeremiahPicture),


    ];

    return results.map(person => person.build());
  }

  render() {
    return (
      <div className='aboutUSPage'>
        <h1 className="aboutUsHeader"> About Us </h1>
        <p className="aboutUsParagraph" >We are students from the University of Central Missouri</p>
        <center>{this.build()}</center>
      </div>
    );
  }
}

export default AboutUSPage;
