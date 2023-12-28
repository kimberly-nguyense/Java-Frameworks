package com.example.demo.validators;

import com.example.demo.domain.Part;
import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class InvValidator implements ConstraintValidator<ValidInv, Part> {
    @Autowired
    private ApplicationContext context;
    public static ApplicationContext applicationContext;
    @Override
    public void initialize(ValidInv constraintAnnotation){
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
    @Override
    public boolean isValid(Part part, ConstraintValidatorContext constraintValidatorContext){
        if(context==null){
            return true;
        }
        if(context!=null){
            applicationContext=context;
        }
        if(part.getInv() >= part.getMinInv() && part.getInv() <= part.getMaxInv()){
            return true;
        }
        if(part.getInv() < part.getMinInv()){
            constraintValidatorContext.buildConstraintViolationWithTemplate("Inventory cannot be less than Minimum Inventory value").addPropertyNode("minInv").addConstraintViolation();
        }
        else if(part.getInv() > part.getMaxInv()){
            constraintValidatorContext.buildConstraintViolationWithTemplate("Inventory cannot be less than Maximum Inventory value").addPropertyNode("maxInv").addConstraintViolation();
        }
        return false;
    }
}
