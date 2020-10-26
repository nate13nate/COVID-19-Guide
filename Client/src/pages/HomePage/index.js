import React from 'react';

import SearchBar from '../../components/SearchBar';
import Title from '../../components/Title';
import Business from '../../classes/Business';
import { getBusinesses } from '../../functions/server';

import './index.css';

class HomePage extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      searchValue: '',
      stateValue: '',
      cityValue: '',
      businesses: [],
    };
  }

  sendSearchValue = (searchValue) => {
    this.setState({ searchValue });
  }

  getSearches = () => {
    if (this.state.searchValue.length === 0 && this.state.stateValue.length === 0 && this.state.cityValue.length === 0) return null;
    const results = this.state.businesses.filter(business => 
      (business.getName().toLowerCase().includes(this.state.searchValue.toLowerCase()) || this.state.searchValue === '')
      && (business.getAddress().city.toLowerCase() === this.state.cityValue.toLowerCase() || this.state.cityValue === '')
      && (business.getAddress().state.toLowerCase() === this.state.stateValue.toLowerCase() || this.state.stateValue === '')
    );
    if (results.length > 0) return results.map(business => business.getSearchResult());
    else return <div className='SearchMessage'>Sorry, but we didn't find any results that matched your search</div>
  }

  updateBusinesses = async () => {
    const businesses = await getBusinesses();
    const classBusinesses = businesses.data.map(business => new Business(
      business.id,
      business.name,
      business.imageFilesList,
      business.hoursOfOperation,
      business.covidRules,
      business.address,
    ));
    this.setState({ businesses: classBusinesses });
  }



  componentDidMount() {
    this.updateBusinesses();
  }

  render() {
    return (
      <div className='HomePage'>
        <Title title='Welcome to the COVID-19 Guide!' visible={this.state.searchValue.length < 1 && this.state.stateValue.length < 1 && this.state.cityValue.length < 1} />
        <SearchBar
          value={this.state.searchValue}
          sendValue={this.sendSearchValue}
          placeholder="Type in here to search for a business's COVID information"
        />
        <div className='Row'>
          <input className='FilterInput' type='text' placeholder='Filter by city' value={this.state.cityValue} onChange={(e) => { this.setState({ cityValue: e.target.value }); }}></input>
          <input className='FilterInput' type='text' placeholder='Filter by state code' maxLength='2' value={this.state.stateValue} onChange={(e) => { this.setState({ stateValue: e.target.value }); }}></input>
        </div>
        <div className='HomePageResultsList'>
          {this.getSearches()}
        </div>
      </div>
    );
  }
}

export default HomePage;
