import React from 'react';
import { Router, Route } from 'react-router-dom';
import './index.css';

import HomePage from './pages/HomePage';
import LoginPage from "./pages/LoginPage"
import BusinessDetailsPage from './pages/BusinessDetailsPage';
import Header from './components/Header';
import history from './history';
import AboutUSPage from './pages/AboutUSPage';
import SignupPage from './pages/SignupPage';
import BusinessSignUpPage from './pages/BusinessSignUpPage';
import HelpPage from './pages/HelpPage';

class App extends React.Component {
  constructor(props) {
    super(props);

    this.setStateApp = this.setStateApp.bind(this);

    this.state = {
      id: -1,
      email: '',
      isConsumer: false,
      signedIn: false,
    };
  }

  setStateApp() {
    if (arguments.length === 1) this.setState(arguments[0]);
    else this.setState(arguments[0], arguments[1]);
  }

  render() {
    return (
      <div className='App'>
        <Router history={history}>
          <Header email={this.state.email} signedIn={this.state.signedIn} setStateApp={this.setStateApp} />
          <Route path='/' render={() => (this.state.signedIn && !this.state.isConsumer) ? <BusinessDetailsPage id={this.state.id} setStateApp={this.setStateApp} signedIn={this.state.signedIn} isBusiness={true} /> : <HomePage />} exact />
          <Route path='/login' render={() => {
            if (!this.state.signedIn) return <LoginPage setStateApp={this.setStateApp} />
            history.push('/');
          }} exact />
          <Route path='/signup' render={() => {
            if (!this.state.signedIn) return <SignupPage setStateApp={this.setStateApp} />;
            history.push('/');
          }} exact />
          <Route path='/aboutUS' component={AboutUSPage} exact />
          <Route path='/:id/view' render={(info) => {
            if (this.state.signedIn && !this.state.isConsumer) history.push('/');
            else return <BusinessDetailsPage match={info.match} signedIn={this.state.signedIn} />
          }} exact />
          <Route path='/help' component={HelpPage} exact />
          {/* <Route path='/signup/business' component={BusinessSignUpPage} exact /> */}
        </Router>
      </div>
    );
  }
}

export default App;
