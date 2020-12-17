package com.mia.bookstore.service;

import org.springframework.stereotype.Service;

@Service
public class RandomStringGeneratorService {

    public String getAlphaNumericString(int n) {

        String alphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        StringBuilder stringBuilder = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            int index = (int) (alphaNumericString.length()
                    * Math.random());
            stringBuilder.append(alphaNumericString).charAt(index);
        }
        return stringBuilder.toString();
    }

    public String linkCreator(String activationCode, String path) {
        String link = path + "/userValidation" + "?" + "actiavtionCode=" + activationCode;

        return link;
    }
}
