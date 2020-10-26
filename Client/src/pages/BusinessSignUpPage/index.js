import React from 'react';

import SearchBar from '../../components/SearchBar';
import history from '../../history';


import { updateBusiness } from "../../functions/server"
import './index.css';
import Business from '../../classes/Business';

class SignupPage extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      name: '',
      Description: '',
      CovidRules: '',
      other: '',
      hours: '',

    };
  }

  updateName = (name) => {

   // alert(name);
    this.setState({ name });
  }

  updatePassword = (password) => {
    this.setState({ password });
  }

  updateConfPassword = (confPassword) => {
    this.setState({ confPassword });
  }

  signUp = (e) => {
    e.preventDefault();

    
    
    history.push('/');

    alert(this.name);
    updateBusiness(new Business(100,this.name,null,"9-5","Wear mask","123232 10st"));
  }





  render() {
    return (
      <div className='SignupPage'>
        <h1 className="businessHeader">Business Signup page </h1>
        <SearchBar value={this.state.name} sendValue={this.updateName} placeholder='Name ' />

        <SearchBar value={this.state.username} sendValue={this.updateName} placeholder='Description' />
        <SearchBar isPassword={false} value={this.state.password} sendValue={this.updateName} placeholder='Covid Rules' />
        <SearchBar isPassword={false} value={this.state.confPassword} sendValue={this.updateName} placeholder='Hours' />
        <SearchBar isPassword={false} value={this.state.confPassword} sendValue={this.updateName} placeholder='Early bird hours' />
        <SearchBar isPassword={false} value={this.state.confPassword} sendValue={this.updateName} placeholder='Other' />

        <button className="signupButton" onClick={this.signUp}>Sign Up</button>
      </div>
    );
  }
}

export default SignupPage;

  