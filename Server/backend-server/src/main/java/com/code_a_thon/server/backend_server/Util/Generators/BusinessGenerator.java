package com.code_a_thon.server.backend_server.Util.Generators;

import com.code_a_thon.server.backend_server.Entity.Business;
import com.code_a_thon.server.backend_server.Entity.BusinessProperties.Address;
import com.code_a_thon.server.backend_server.Entity.BusinessProperties.HoursOfOperation;
import com.code_a_thon.server.backend_server.Entity.UserType;
import com.code_a_thon.server.backend_server.Repository.AccountRepository;
import com.code_a_thon.server.backend_server.Repository.AddressRepository;
import com.code_a_thon.server.backend_server.Repository.BusinessRepository;
import com.code_a_thon.server.backend_server.Repository.HoursOfOperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

@Service
public class BusinessGenerator {
    @Autowired
    private AccountGenerator accountGenerator;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private BusinessRepository businessRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private HoursOfOperationRepository hoursOfOperationRepository;

    private Random random;

    public BusinessGenerator() {
        random = new Random();
    }

    public Business createBusiness() {
        Business business = new Business();
        business.setAccountOwnerId(accountGenerator.createAccount(UserType.BUSINESS).getId());
        business.setName(getBusinessName());
        business.setMaxOccupancy(random.nextInt(100));
        business.setCovidRules(getCovidRules());
        business.setAtRiskPopulationBusinessHours(getAtRiskPopulationBusinessHours());
        business.setHoursOfOperation(getHoursOfOperationList());
        business.setAddress(getAddress());

        return business;
    }

    private String getAtRiskPopulationBusinessHours() {
        String hours = "";

        int timeLength = random.nextInt(2)+1;
        int startHour = random.nextInt(12)+6;
        String startLabel = "am";
        String endLabel = "am";
        int endHour = startHour+timeLength;

        if(startHour >= 12)
            startLabel = "pm";
        if(startHour > 12)
            startHour -=12;

        if(endHour >= 12)
            endLabel = "pm";
        if(endHour > 12)
            endHour -=12;


        hours += startHour + startLabel + " - " + endHour + endLabel;

        return hours;
    }

    private String[] getCovidRules() {
        final String[] POTENIAL_RULES = new String[]{
                "Masks are required",
                "Curbside delivery is available",
                "Customers who visited others states within the last 30 days are discouraged from visiting",
                "Social distancing is required"
        };

        String[] covidRules = new String[random.nextInt(3)+1];

        String[] unusedRules = POTENIAL_RULES;
        for (int i = 0; i < covidRules.length; i++) {
            int lastRandom = POTENIAL_RULES.length;
            String rule = "";
            while (rule.equals("")) {
                lastRandom = random.nextInt(POTENIAL_RULES.length);
                rule = POTENIAL_RULES[lastRandom];
            }
            unusedRules[lastRandom] = "";
            covidRules[i] = rule;
        }

        return covidRules;
    }

    private Address getAddress() {
        Address address = new Address();
        address.setCity(getCityName());
        address.setState(getStateName());
        address.setStreetAddress("234798");
        address.setZip(getZip());

        addressRepository.save(address);

        return address;
    }

    private List<HoursOfOperation> getHoursOfOperationList() {
        final String[] daysOfWeek = new String[]{"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};

        List<HoursOfOperation> hoursOfOperationList = new ArrayList<>();

        for(String dayOfWeek : daysOfWeek) {
            boolean isOpen = random.nextInt(7) < 6;
            String hours = "Closed";
            if(isOpen)
                hours = "6am - 6pm";

            hoursOfOperationList.add(new HoursOfOperation(dayOfWeek, hours));
        }
        hoursOfOperationRepository.saveAll(hoursOfOperationList);

        return hoursOfOperationList;
    }

    private String getBusinessName() {
        String name;
        Scanner sc;
        String[] bnames = new String[100];
        File BusinessNamesFile = new File("src/main/java/com/code_a_thon/server/backend_server/Util/Datasets/business_names.csv");
        try
        {
            sc = new Scanner(BusinessNamesFile);
            sc.useDelimiter("\n");

            for(int i=0; i<bnames.length; i++) {
                bnames[i] = sc.next();
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        name = bnames[random.nextInt(bnames.length)].replace("\r","");
        return name;

    }
    private String getCityName()
    {
        String city;
        Scanner sc = null;
        String[] citynames = new String[200];
        File CityNamesFile = new File("src/main/java/com/code_a_thon/server/backend_server/Util/Datasets/city_names.csv");
        try
        {
            sc = new Scanner(CityNamesFile);
            sc.useDelimiter("\n");
            for(int i=0; i<citynames.length; i++) {

                citynames[i] = sc.next();
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        city = citynames[random.nextInt(citynames.length)].replace("\r","");

        return city;
    }
    private String getStateName()
    {
        String state;
        Scanner sc = null;
        String[] statenames = new String[50];
        File StateNamesFile = new File("src/main/java/com/code_a_thon/server/backend_server/Util/Datasets/state_abbreviations.csv");
        try
        {
            sc = new Scanner(StateNamesFile);
            sc.useDelimiter("\n");
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        for(int i=0; i<statenames.length; i++) {

            statenames[i] = sc.next();
        }
        state = statenames[random.nextInt(statenames.length)].replace("\r","");

        return state;
    }
    private int getZip()
    {
      int zip;
      Scanner sc = null;
      String[] zipcodes = new String[100];
      File ZipCodeFile = new File("src/main/java/com/code_a_thon/server/backend_server/Util/Datasets/zipcode.csv");
        try
        {
            sc = new Scanner(ZipCodeFile);
            sc.useDelimiter("\n");
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        for(int i = 0; i < zipcodes.length; i++) {

            zipcodes[i] = sc.next();
        }
        zip = Integer.parseInt(zipcodes[random.nextInt(zipcodes.length)].replace("\r",""));
      return zip;
    }
}
