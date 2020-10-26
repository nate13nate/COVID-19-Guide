import React from 'react';

import './index.css';

/**
 * Props:
 * value: holds the value of the search bar
 * sendValue: sends the value to the parent
 * placeholder: sets placeholder attribute of text input
 * isPassword: whether the input is a password or not; defaults to false
 */
class SearchBar extends React.Component {
  onChange = (e) => {
    e.preventDefault();
    this.props.sendValue(e.target.value);
  }

  determineType = () => {
    if (this.props.isPassword) return 'password';
    if (this.props.isEmail) return 'email';
    return 'text';
  }

  render() {
    return (
      <div className={`SearchBar SearchBar${this.props.placeholder.replace(' ', '')}`}>
        <input
          type={this.determineType()}
          minLength={this.props.isPassword ? 8 : 0}
          maxLength={this.props.isPassword ? 30 : 100}
          className='SearchBarInput'
          value={this.props.value}
          onChange={this.onChange}
          placeholder={this.props.placeholder || ''}
          required={this.props.required}
        />
      </div>
    );
  }
}

export default SearchBar;
