import React from 'react';

import defaultLogo from '../../images/defaultlogo.png';
import bookmark from '../../images/bookmark.png';
import history from '../../history';

import './index.css';

class Business {
  constructor(id, name, pictures, hours, covid, address) {
    this.id = id;
    this.name = name;
    this.pictures = pictures || [];
    this.hours = hours || [];
    this.covid = covid || [];
    this.logo = <img className='SearchResultLogoImg' src={defaultLogo} alt='Logo' />;
    this.address = address;
  }

  getId = () => {
    return this.id;
  }

  setLogo = (logo) => {
    this.logo = logo;
  }

  getName = () => {
    return this.name;
  }

  getPictures = () => {
    return this.pictures;
  }

  getHours = () => {
    return this.hours;
  }

  getCovid = () => {
    return this.covid;
  }

  getAddress = () => {
    return this.address;
  }

  changePage = (e) => {
    e.preventDefault();
    const path = `/${this.id}/view`;
    history.push(path);
  }

  getSearchResult = () => {
    return (
      <div className='SearchResult' key={this.id} onClick={this.changePage}>
        <div className='SearchResultLogo'>{this.logo}</div>
        <div className='SearchResultName'>{this.name}</div>
      </div>
    );
  }

  getHomeTab = (signedIn) => {
    return (
      <div className={'BusinessDetailsTabHome'}>
        <div className='BusinessDetailsTabHomeFirstRow'>
          <div className='BusinessDetailsTabHomeLogo'>{this.logo}</div>
          <div className='BusinessDetailsTabHomeName'>{this.name}</div>
          {signedIn ? <div className='BusinessDetailsTabHomeBookmark'><img className='BookmarkImage' src={bookmark} alt='Bookmark' /></div> : <div className='BusinessDetailsTabHomeSpace'></div>}
        </div>
        <div className='BusinessDetailsTabHomeAddress'>
          <div className='AddressLine1'>{this.address.streetAddress}</div>
          <div className='AddressLine2'>{this.address.city}, {this.address.state} {this.address.zip === 0 ? '' : this.address.zip}</div>
        </div>
      </div>
    );
  }

  editHomeTab = (state, setState) => {
    return (
      <div className={'BusinessDetailsTabHome'}>
        <div className='BusinessDetailsTabHomeFirstRow'>
          {/* <div className='BusinessDetailsTabHomeLogo'>{this.logo}</div> */}
          <input placeholder='Business Name' type='text' value={state.name} onChange={(e) => { setState({ ...state, name: e.target.value }); }} className='BusinessDetailsTabHomeNameInput EditBusinessInput'></input>
          {/* <div className='BusinessDetailsTabHomeSpace'></div> */}
        </div>
        <div className='BusinessDetailsTabHomeAddress'>
          <div className='AddressLine1Input'><input placeholder='Street Address' type='text' className='EditBusinessInput' value={state.streetAddress} onChange={(e) => { setState({ ...state, streetAddress: e.target.value }); }} /></div>
          <div className='AddressLine2Input'>
            <input placeholder='City' className='EditBusinessInput MarginRight' type='text' value={state.city} onChange={(e) => { setState({ ...state, city: e.target.value }); }} />
            <input placeholder='State' className='EditBusinessInput MarginRight' type='text' value={state.state} onChange={(e) => { setState({ ...state, state: e.target.value }); }} />
            <input placeholder='Zip Code' className='EditBusinessInput' type='number' value={state.zip} onChange={(e) => { setState({ ...state, zip: e.target.value }); }} />
          </div>
        </div>
      </div>
    );
  }

  getPicturesTab = () => {
    return (
      <div className='BusinessDetailsTabPicture'>

      </div>
    );
  }

  getHourTab = () => {
    return (
      <div className='BusinessDetailsTabHour'>
        {this.hours.map((day, index) => (
          <div className='TabHourDay' key={index}>
            <div className='TabHourDayOfWeek'>{day.dayOfWeek}</div>
            <div className='TabHourHours'>{day.hours}</div>
          </div>
        ))}
      </div>
    );
  }

  editHourTab = (state, setState) => {
    const daysOfWeek = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'];
    return (
      <div className='BusinessDetailsTabHour'>
        {daysOfWeek.map((day, index) => (
          <div className='TabHourDay' key={index}>
            <div className='TabHourDayOfWeek'>{day.dayOfWeek}</div>
            <input type='text' value={state.hours.find(hour => hour.dayOfWeek === day).hours} onChange={(e) => {
              const newHours = state.hours;
              for (let i = 0; i < newHours.length; i += 1) {
                if (newHours[i].dayOfWeek === day.dayOfWeek) newHours[i].hours = e.target.value;
              }
              setState({ ...state, hours: newHours });
            }} className='EditBusinessInput'></input>
          </div>
        ))}
      </div>
    );
  }

  getCovidTab = () => {
    return ( 

      <div className ="covidRules">
      <h1 className ="covidRulesHeader">Covid Rules</h1>
      <ul className='BusinessDetailsTabCovid'>
        {this.covid.map((rule, index) => <li className='TabCovidRule' key={index}>{rule}</li>)}
      </ul>

      </div>
    );
  }

  editCovidTab = (state, setState) => {
    return (
      <ul className='BusinessDetailsTabCovid'>
        {state.covid.map((rule, index) => <li className='TabCovidRule' key={index}>
          <input className='EditBusinessInput' type='text' value={rule} placeholder='If you put in nothing, the rule will be deleted.' onChange={(e) => {
            const newCovid = state.covid;
            newCovid[index] = e.target.value;
            if (index + 1 === newCovid.length) newCovid.push('');
            setState({ ...state, covid: newCovid });
          }} />
        </li>
        )}
      </ul>
    );
  }
}

export default Business;
