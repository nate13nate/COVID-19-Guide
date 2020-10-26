import React from 'react';

import SearchBar from '../../components/SearchBar';
import history from '../../history';
import { signIn } from '../../functions/server';

import './index.css';

class LoginPage extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      email: "",
      password: "",
    };

  }

  updateEmail = (email) => {
    this.setState({ email })
  }

  updatePassword = (password) => {
    this.setState({ password })
  }


  login = async (e) => {
    e.preventDefault();

    const account = await signIn(this.state.email, this.state.password);
    if (account.data) {
      this.props.setStateApp({ signedIn: true, id: account.data.id, email: this.state.email, isConsumer: account.data.type === 'USER' }, () => {
        history.push('/');
      });
    } else {
      alert('Incorrect username or password');
    }
  }

  render() {
    return (
      <form className='loginPage' onSubmit={this.login}>
        <SearchBar required={true} isEmail={true} value={this.state.email} sendValue={this.updateEmail} placeholder='Email' />
        <SearchBar required={true} isPassword={true} value={this.state.password} sendValue={this.updatePassword} placeholder='Password' />
        <button type='submit' className="loginButton">Login</button>
      </form>
    );
  }
}

export default LoginPage;
