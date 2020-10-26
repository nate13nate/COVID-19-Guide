// import React from 'react';

import homeIcon from '../../../images/homeicon.svg';
import BusinessDetailsTab from '../index';

import './index.css';

export const homeTabName = 'Home';
export const homeTabIcon = homeIcon;

class HomeTab extends BusinessDetailsTab {
  constructor(props) {
    super(props, homeIcon, homeTabName);
  }

  setDisplay = () => {
    if (this.props.edit) return this.props.business.editHomeTab(this.props.newBusiness, this.props.sendInfo);
    else return this.props.business.getHomeTab(this.props.signedIn);
  }
}

export default HomeTab;
