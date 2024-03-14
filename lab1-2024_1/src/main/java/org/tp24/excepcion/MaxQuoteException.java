package org.tp24.excepcion;

import org.jetbrains.annotations.NotNull;

public class MaxQuoteException extends ClientException {
    public MaxQuoteException(@NotNull Double quote){
        super(STR."Was not found clients with the max quote \{quote.toString()}");
    }
}
