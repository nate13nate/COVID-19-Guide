import React from 'react';

import './index.css';

/**
 * Props:
 * value: holds the value of the search bar
 * sendValue: sends the value to the parent
 * placeholder: sets placeholder attribute of text input
 */
class LoginField extends React.Component {


    render() {
        return (
            <div className='loginField'>

                <h2 className="headerText"> {this.props.title} </h2>
                <input
                    type={this.props.type}
                    className='loginFieldInput'
                    value={this.props.value}
                    onChange={this.props.onChange}
                    placeholder={this.props.placeholder || this.props.title || ''}
                />
            </div>
        );
    }
}

export default LoginField;
