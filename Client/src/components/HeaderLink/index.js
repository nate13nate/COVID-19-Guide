import React from 'react';

import history from '../../history';

import logo from '../../images/logo.png'


import './index.css';


/**
 * Props:
 * 
 * name - String; name of link
 * representative - anything; what's representing the string; defaults to name
 * location - String; location link will take user
 * clickable - boolean; whether the link can be clicked or not; true by default
 */
class HeaderLink extends React.Component {
  changePath = (e) => {
    e.preventDefault();
    if (this.props.otherAction) this.props.otherAction();
    history.push(this.props.location);
  }

  generateHeaderItem = () => {

    if (this.props.name !== "Logo")
      return (this.props.representative || <div className='HeaderLinkText'>{this.props.name}</div>);

    else
      return (<img className="logoImage" src={logo} alt='Covid Guide Book'></img>);

  }



  render() {
    return (
      <div
        className={'HeaderLink HeaderLink' + this.props.name.replace(' ', '')}
        onClick={this.changePath} disabled={!this.props.clickable || false}>


        {this.generateHeaderItem()}


      </div>
    );
  }
}

export default HeaderLink;
