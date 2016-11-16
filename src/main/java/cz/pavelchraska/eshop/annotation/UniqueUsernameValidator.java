package cz.pavelchraska.eshop.annotation;

import cz.pavelchraska.eshop.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    @Autowired
    private UserDao userDao;

    public void initialize(UniqueUsername uniqueUsername) {

    }

    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(userDao==null){
            return true;
        }
        return userDao.findByName(s) == null;
    }
}
