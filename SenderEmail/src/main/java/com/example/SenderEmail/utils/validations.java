package com.example.SenderEmail.utils;

import java.util.regex.Pattern;

public class validations {

    public boolean areValidEmails(String[] emails) {
        if (emails == null) {
            return false;
        }

        for (String email : emails) {
            if( !isValidEmails( email ))
                return false;
        }
        return true;
    }

 public boolean  isValidEmails(String  email ){
     if (email == null) {
         return false;
     }
     String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
     Pattern pattern = Pattern.compile(emailRegex);
     if (!pattern.matcher(email).matches()) {
              return false;
           }
     return true;
 }


}
