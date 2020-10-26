import React from 'react';

import SearchBar from '../../components/SearchBar';
import history from '../../history';
import { signUp } from '../../functions/server';

import './index.css';

class SignupPage extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      email: '',
      password: '',
      confPassword: '',
      consumerChecked: false,
      businessChecked: false,
    };
  }

  updateEmail = (email) => {
    this.setState({ email });
  }

  updatePassword = (password) => {
    this.setState({ password });
  }

  updateConfPassword = (confPassword) => {
    this.setState({ confPassword });
  }

  signUp = async (e) => {
    e.preventDefault();

    const { email, password, confPassword, consumerChecked } = this.state;

    if (password !== confPassword) alert('Error: The password and confirm password fields do not match.');
    else {
      const response = await signUp(email, password, consumerChecked);
      if (!response.data) {
        alert('There was an error in making your account, most likely because the email is already in use.');
      } else {
        this.props.setStateApp({ email: email, password: password, isConsumer: consumerChecked, signedIn: true, id: response.data.id });
        history.push('/');
      }
    }
  }

  selectConsumer = () => {
    this.setState({ consumerChecked: true, businessChecked: false });
  }

  selectBusiness = () => {
    this.setState({ businessChecked: true, consumerChecked: false });
  }

  render() {
    return (
      <form className='SignupPage' onSubmit={this.signUp}>
        <SearchBar required={true} isEmail={true} value={this.state.email} sendValue={this.updateEmail} placeholder='Email' />
        <SearchBar required={true} isPassword={true} value={this.state.password} sendValue={this.updatePassword} placeholder='Password' />
        <SearchBar required={true} isPassword={true} value={this.state.confPassword} sendValue={this.updateConfPassword} placeholder='Confirm Password' />
        <div className='SignupPageConBis'>
          <div className='SignupPageRadioContainer'>
            <input onChange={this.selectConsumer} className='SignupPageRadio' id='consumerRadio' type='radio' name='conOrBis' value='consumer' checked={this.state.consumerChecked} required />
            <label className='SignupPageLabel' htmlFor='consumerRadio'>I am a consumer</label>
          </div>
          <div className='SignupPageRadioContainer'>
            <input onChange={this.selectBusiness} className='SignupPageRadio' id='businessRadio' type='radio' name='conOrBis' value='business' checked={this.state.businessChecked} required />
            <label className='SignupPageLabel' htmlFor='businessRadio'>I am a business</label>
          </div>
        </div>
        <button className="signupButton">Sign Up</button>
      </form>
    );
  }
}

export default SignupPage;
