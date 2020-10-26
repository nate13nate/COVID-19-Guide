import React from 'react';

import HeaderLink from '../HeaderLink';

import './index.css';

/**
 * Props:
 * Based off of signed in and such
 */
class Header extends React.Component {
  logout = () => {
    this.props.setStateApp({ signedIn: false, username: '', password: '', });
  }

  render() {
    return (
      <div className='Header'>
        <HeaderLink name='Logo' location='/' />
        {this.props.signedIn
          ? <HeaderLink name='Logout' location='/' otherAction={this.logout} />
          : <HeaderLink name='Login' location='/login' />}
        {this.props.signedIn
          ? null
          : <HeaderLink name='Sign Up' location='/signup' />}
        {/* <HeaderLink name='Settings' location='/settings' /> */}
        <HeaderLink name='Help' location='/help' />
        <HeaderLink name='About us' location='/aboutus' />
        {this.props.signedIn ? <HeaderLink name={this.props.email} location='/bookmarked' /> : null}
      </div>
    );
  }
}

export default Header;
