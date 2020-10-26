import React from 'react';

import './index.css';

/**
 * Props:
 * title - the title that you want to show
 * visible - true by default; set to false if you want to collapse the title
 */
class Title extends React.Component {
  render() {
    return (
      <div className='Title' style={this.props.visible ? {} : { height: 0, marginTop: '0', marginBottom: '0' }}>
        <div style={this.props.visible ? { opacity: '1' } : { opacity: '0' }} className='TitleTextWrapper'>{this.props.title}</div>
      </div>
    );
  }
}

export default Title;
