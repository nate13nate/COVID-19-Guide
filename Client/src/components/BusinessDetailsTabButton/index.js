import React from 'react';

import './index.css';

class BusinessDetailsTabButton extends React.Component {
  onClick = (e) => {
    e.preventDefault();
    if (this.props.currTab !== this.props.name) this.props.setCurrTab(this.props.name);
  }

  render() {
    return (
      <div
        className='BusinessDetailsTabButton'
        style={this.props.currTab === this.props.name ? { backgroundColor: 'rgb(36, 175, 145)', cursor: 'default' } : {}}
        onClick={this.onClick}
      >
        <img className='BusinessDetailsTabButtonImg' src={this.props.logo} alt={this.props.name} />
      </div>
    );
  }
}

export default BusinessDetailsTabButton;
