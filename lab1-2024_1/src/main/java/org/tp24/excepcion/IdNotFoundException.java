package org.tp24.excepcion;

public class IdNotFoundException extends ClientException {
    public IdNotFoundException(String id) {
        super(STR."The id: \{id} was not found");
    }
}
