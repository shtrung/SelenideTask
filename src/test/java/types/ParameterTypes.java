package types;

import io.cucumber.java.ParameterType;

public class ParameterTypes {

    @ParameterType("true|false")
    public boolean booleanValue (String value) {
        return Boolean.parseBoolean(value);
    }
}
