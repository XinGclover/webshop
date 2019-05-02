package controller;

import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("emptyAndSpecialCharValidator")
public class EmptyAndSpecialCharactersValidator implements Validator {
	
	 Pattern NotAZaz09 = Pattern.compile("[^\\w ]");

	public EmptyAndSpecialCharactersValidator() {
	}

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {

		String input = (String) arg2;

		if (input.equals("")) {
			throw new ValidatorException(
				new FacesMessage(FacesMessage.SEVERITY_ERROR,
					(arg1.getId() + " cannot be empty!"),
					null));
		}

		if (NotAZaz09.matcher(input).find()) {
			throw new ValidatorException(
				new FacesMessage(FacesMessage.SEVERITY_ERROR,
					(arg1.getId() + " contains invalid characters!"),
					null));
		}
	}

}
