package utils;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter("doubleConverter")
public class DoubleConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (context != null && component != null) {
            if (value == null) {
                return null;
            } else {
                value = value.trim();
                if (value.length() > 17) {
                    return null;
                } else if (value.length() < 1) {
                    return null;
                } else {
                    try {
                        return Double.valueOf(value);
                    } catch (Exception e) {
                        throw new ConverterException(e);
                    }
                }
            }
        } else {
            throw new NullPointerException();
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (context != null && component != null) {
            if (value == null) {
                return "";
            } else if (value instanceof String) {
                return (String) value;
            } else {
                try {
                    return Double.toString(((Number) value).doubleValue());
                } catch (Exception e) {
                    throw new ConverterException(e);
                }
            }
        } else {
            throw new NullPointerException();
        }
    }
}
