// import React from 'react';

import pictureIcon from '../../../images/pictures.png';
import BusinessDetailsTab from '..';

import './index.css';

export const picturesTabName = 'Pictures';
export const picturesTabIcon = pictureIcon;

class PicturesTab extends BusinessDetailsTab {
  constructor(props) {
    super(props, pictureIcon, picturesTabName);
  }

  setDisplay = () => {
    return this.props.business.getPicturesTab();
  }
}

export default PicturesTab;