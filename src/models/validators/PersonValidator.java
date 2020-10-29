package models.validators;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import models.Person;
import utils.DBUtil;


public class PersonValidator {
    public static List<String> validate(Person p, Boolean number_duplicate_check_flag, Boolean password_check_flag) {
        List<String> errors = new ArrayList<String>();

        String number_error = _validateNumber(p.getNumber(), number_duplicate_check_flag);
        if(!number_error.equals("")) {
            errors.add(number_error);
        }

        String name_error = _validateName(p.getName());
        if(!name_error.equals("")) {
            errors.add(name_error);
        }

        String password_error = _validatePassword(p.getPassword(), password_check_flag);
        if(!password_error.equals("")) {
            errors.add(password_error);
        }

        return errors;
    }

    // パーソン番号
    private static String _validateNumber(String number, Boolean number_duplicate_check_flag) {
        // 必須入力チェック
        if(number == null || number.equals("")) {
            return "パーソン番号を入力してください。";
        }

        // すでに登録されているパーソン番号との重複チェック
        if(number_duplicate_check_flag) {
            EntityManager em = DBUtil.createEntityManager();
            long persons_count = (long)em.createNamedQuery("checkRegisteredNumber", Long.class)
                                          .setParameter("number", number)
                                          .getSingleResult();
            em.close();
            if(persons_count > 0) {
                return "入力された社員番号の情報はすでに存在しています。";
            }
        }
        return "";
    }

    // 社員名の必須入力チェック
    private static String _validateName(String name) {
        if(name == null || name.equals("")) {
            return "氏名を入力してください。";
        }
        return "";
    }
    // パスワードの必須入力チェック
    private static String _validatePassword(String password, Boolean password_check_flag) {
        // パスワードを変更する場合のみ実行
        if(password_check_flag && (password == null || password.equals(""))) {
            return "パスワードを入力してください。";
        }
        return "";
    }


}
