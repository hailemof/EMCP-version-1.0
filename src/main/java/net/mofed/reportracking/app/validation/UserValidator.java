package net.mofed.reportracking.app.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import net.mofed.reportracking.app.model.User;
import net.mofed.reportracking.app.service.UserService;

@Component
public class UserValidator implements Validator{
	 @Autowired
	    private UserService userService;

	    @Override
	    public boolean supports(Class<?> aClass) {
	        return User.class.equals(aClass);
	    }

	   @Override
	    public void validate(Object o, Errors errors) {
	        User user = (User) o;
	        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.user.email");
	        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "roles", "NotEmpty.user.roles");
	       // ValidationUtils.rejectIfEmptyOrWhitespace(errors, "organization", "NotEmpty.user.organization");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
	        if (user.getUsername().length() < 2 || user.getUsername().length() > 90) {
	            errors.rejectValue("username", "Size.user.username");
	        }
	       
	        if (userService.getUserByUsername(user.getUsername()) != null) {
	            errors.rejectValue("username", "Duplicate.user.username");
	        }

	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
	        if (user.getPassword().length() < 2 || user.getPassword().length() > 120) {
	            errors.rejectValue("password", "Size.user.password");
	        }

	        if (!user.getConfirmPassword().equals(user.getPassword())) {
	            errors.rejectValue("confirmPassword", "Diff.user.confirmPassword");
	        }
	    }
	}