package io.jamalahi.neptuna.presenter;

import junit.framework.Assert;

import org.junit.Test;

import io.jamalahi.neptuna.presenters.Validator;

/**
 * Created by amanatu on 31/01/18.
 */

public class ValidatorTest {
    @Test
    public void testValidateEmail(){
        boolean expected = true;
        boolean actual = Validator.validateEmail("jamalahi30@gmail.com");

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testValidatePassword(){
        Assert.assertEquals(true,Validator.validatePassword("99a200m12061993"));
    }

}
