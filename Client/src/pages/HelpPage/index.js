import React from 'react';

import SearchBar from '../../components/SearchBar';
import history from '../../history';

import './index.css';
import { Link } from 'react-router-dom';

class HelpPage extends React.Component {
  constructor(props) {
    super(props);

  }







  render() {
    return (
      <div class="helpPage">
        <h1 className="helpHeader"> Help page </h1>

        <div className="helpBox">
          <h2> Problem explanation:</h2>
          <p>Covid changes day by day, and sometimes communication between business and consumer can be lost.</p>
        </div>

        <div className="helpBox">
          <h2>How to use:</h2>
 
          <p> On the <Link to="/">homepage</Link> search for a business and select the business you would like to view from the list. Clicking on a business will bring you to the business details page where you will be able to see Covid-19 rules, Operation Hours, and more. The subscribe button will ensure that if a change is made you will receive an email notification. If you do not have an account you can create one on the <Link to="/signup"> Signup page.</Link></p>
        </div>

        <div className="helpBox">
          <h2>How to add your business:</h2>
          <p> To create a business go to the <Link to="/signup">Sign Up page</Link> enter an email and password and select I am a business. Once you submit you will be taken to the business sign up page where you can enter all your information which will be stored in the database and ready to be searched by users. </p>
        </div>
      </div>
    );
  }
}

export default HelpPage;
