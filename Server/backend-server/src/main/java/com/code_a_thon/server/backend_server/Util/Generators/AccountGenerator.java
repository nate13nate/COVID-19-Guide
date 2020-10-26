package com.code_a_thon.server.backend_server.Util.Generators;

import com.code_a_thon.server.backend_server.Entity.Account;
import com.code_a_thon.server.backend_server.Entity.UserType;
import com.code_a_thon.server.backend_server.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

@Service
public class AccountGenerator {
    private static final int NAMES_LENGTH  = 100;
    private static String[] firstNames = new String[NAMES_LENGTH];
    private static String[] lastNames = new String[NAMES_LENGTH];

    private static Random random = new Random();

    @Autowired
    private AccountRepository accountRepository;

    public AccountGenerator() {
        loadDataFiles();
    }

    public Account createAccount(UserType userType) {
        Account account = new Account();

        account.setEmail(firstNames[random.nextInt(firstNames.length)].replace("\r","")+"."+lastNames[random.nextInt(lastNames.length)]+getEmailDomain());
        account.setHash(getHash());
        account.setType(userType);

        accountRepository.save(account);
        return account;
    }

    private String getHash() {
        String hash = "";
        for (int i = 0; i < 64; i++) {
            boolean isChar = random.nextBoolean();
            if(isChar) {
                hash += (char) (random.nextInt(26)+97);
            } else {
                hash += random.nextInt(10);
            }

        }
        return hash;
    }

    private void loadDataFiles() {
        Scanner sc;
        File firstNamesFile = new File("src/main/java/com/code_a_thon/server/backend_server/Util/Datasets/first-names.csv");
        File lastNamesFile = new File("src/main/java/com/code_a_thon/server/backend_server/Util/Datasets/last-names.csv");

        // First names
        try {
            sc = new Scanner(firstNamesFile);
            sc.useDelimiter("\n");

            for(int i=0; i<firstNames.length; i++) {
                firstNames[i] =sc.next();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Last names
        try {
            sc = new Scanner(lastNamesFile);

            for(int i=0; i<lastNames.length; i++) {
                lastNames[i] = sc.next();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private String getEmailDomain()
    {
        String domain;
        Scanner sc = null;
        String[] domainnames = new String[8];
        File DomainNamesFile = new File("src/main/java/com/code_a_thon/server/backend_server/Util/Datasets/email_domains.csv");
        try
        {
            sc = new Scanner(DomainNamesFile);
            sc.useDelimiter("\n");
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        for(int i = 0; i < domainnames.length; i++)
        {
            domainnames[i] = sc.next();
        }
        domain = domainnames[random.nextInt(domainnames.length)].replace("\r","");

        return domain;
    }
}
