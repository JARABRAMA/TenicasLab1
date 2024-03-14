package org.tp24.excepcion;

import static java.lang.StringTemplate.STR;

public class InvalidNameException extends ClientException{
    public InvalidNameException(String name, String lastName){
        super (STR."\{name} \{lastName} was not found");
    }
}
