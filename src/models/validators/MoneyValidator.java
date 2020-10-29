package models.validators;

import java.util.ArrayList;
import java.util.List;

import models.Money;

public class MoneyValidator {
    public static List<String> validate(Money m) {
        List<String> errors = new ArrayList<String>();

        String company_name_error = _validateCompany_name(m.getCompany_name());
        if(!company_name_error.equals("")) {
            errors.add(company_name_error);
        }

        String year_error = _validateYear(m.getYear());
        if(!year_error.equals("")) {
            errors.add(year_error);
        }
        return errors;
    }

    private static String _validateCompany_name(String company_name) {
        if(company_name == null || company_name.equals("")) {
            return "バイト先を入力してください。";
        }
        return "";
    }

    private static String _validateYear(String year) {
        if(year == null || year.equals("")) {
            return "年度を入力してください。";
        }
        return "";
    }
}
