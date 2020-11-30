package utils;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.Map;

@FacesValidator("doubleValidator")
public class DoubleValidator implements Validator {

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        final Map<String, Object> attributes = uiComponent.getAttributes();
        final String name = attributes.get("name").toString();
        Double value = new Double(o.toString());
        try {
            final Double step = new Double(attributes.get("step").toString());
            final FacesMessage msg = new FacesMessage(String.format("Число %s должно делиться на %s", name, step));
            if (value % step != 0) throw new ValidatorException(msg);

        } catch (NullPointerException ignored) {
        } finally {
            final Double min = new Double(attributes.get("min").toString());
            final Double max = new Double(attributes.get("max").toString());
            final FacesMessage msg = new FacesMessage(String.format("Число %s должно входить в промежуток (%s; %s)", name, min, max));
            if (value > max || value < min) throw new ValidatorException(msg);
        }
    }
}
