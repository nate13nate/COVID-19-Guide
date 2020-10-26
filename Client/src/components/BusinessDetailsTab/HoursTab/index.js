// import React from 'react';

import hourIcon from '../../../images/hours.png';
import BusinessDetailsTab from '../index';

import './index.css';

export const hourTabName = 'Hours';
export const hourTabIcon = hourIcon;

class HourTab extends BusinessDetailsTab {
  constructor(props) {
    super(props, hourIcon, hourTabName);

    if (this.props.edit) this.state = {
      hours: this.props.business.getHours(),
    };
  }

  setDisplay = () => {
    if (this.props.edit) return this.props.business.editHourTab(this.state, this.sendSetState);
    return this.props.business.getHourTab();
  }
}

export default HourTab;
