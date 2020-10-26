// import React from 'react';

import covidIcon from '../../../images/covid.png';
import BusinessDetailsTab from '../index';

import './index.css';

export const covidTabName = 'COVID Info';
export const covidTabIcon = covidIcon;

class CovidTab extends BusinessDetailsTab {
  constructor(props) {
    super(props, covidIcon, covidTabName);
  }

  setDisplay = () => {
    if (!this.props.edit) return this.props.business.getCovidTab();
    return this.props.business.editCovidTab(this.props.newBusiness, this.props.sendInfo);
  }
}

export default CovidTab;
