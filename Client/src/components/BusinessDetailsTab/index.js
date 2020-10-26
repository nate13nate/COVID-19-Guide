import React from 'react';

import './index.css';

class BusinessDetailsTab extends React.Component {
  constructor(props, tabLogo, tabName) {
    super(props);

    this.tabLogo = tabLogo;
    this.tabName = tabName;
  }

  setDisplay = () => {
    return null;
  }

  render() {
    return (
        <div className={`BusinessDetailsTabs`}>
          {this.setDisplay()}
        </div>
    );
  }
}

export default BusinessDetailsTab;
