import axios from 'axios';

export const getBusinesses = async () => {
  const response = await axios.get('http://localhost:8080/api/business/');
  return response;
};

export const getBusinessById = async (id) => {
  const response = await axios.get('http://localhost:8080/api/business/findById', {
    params: { id: parseInt(id) },
  });
  return response;
}

export const signIn = async (email, password) => {
  const validCred = await axios.get('http://localhost:8080/api/account/validate', {
    params: {
      email,
      hash: password,
    },
  });
  if (validCred) {
    const account = await axios.get('http://localhost:8080/api/account/findByEmail', {
      params: {
        email,
      },
    });
    return account;
  } else {
    return null;
  }
}

export const updateBusiness = async (business) => {
  const response = await axios.put('http://localhost:8080/api/business/', {
    businessId: business.id,
    maxOccupancy: 1000,
    name: business.name,
    atRiskPopulationBusinessHours: '',
    imageFilesList: '',
    hoursOfOperation: [],
    covidRules: business.covid,
    address: {
      streetAddress: business.streetAddress,
      city: business.city,
      state: business.state,
      zip: business.zip,
    }
  });
  return response;
}

export const createBusiness = async (business) => {
  await axios.post('http://localhost:8080/api/business/', {
    accountOwnerid: business.id,
    name: business.name,
    maxOccupancy: 50,
    covidRules: business.covid,
    atRiskPopulationBusinessHours: '',
    hoursOfOperation: [],
    imageFilesList: '',
    address: {
      streetAddress: business.streetAddress,
      city: business.city,
      state: business.state,
      zip: business.zip,
    }
  });
}

export const signUp = async (email, password, isConsumer) => {
  const duplicateAccount = await axios.get('http://localhost:8080/api/account/findByEmail', {
    params: {
      email,
    },
  });
  if (!duplicateAccount.data) {
    await axios.post('http://localhost:8080/api/account/', {
      email,
      password,
      userType: isConsumer ? 'USER' : 'BUSINESS',
    });
    const account = await axios.get('http://localhost:8080/api/account/findByEmail', {
      params: {
        email,
      },
    });
    return account;
  } else {
    return { data: null };
  }
}

export const getAccounts = async () => {
  const accounts = await axios.get('http://localhost:8080/api/account/');
  return accounts;
}
