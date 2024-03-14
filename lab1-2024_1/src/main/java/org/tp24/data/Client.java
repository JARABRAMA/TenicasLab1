package org.tp24.data;

import java.math.BigDecimal;

public class Client {
    private String id;
    private String name;
    private String lastName;
    private String birthDay;
    private String address;
    private BigDecimal maxQuote;

    public Client(
            String id,
            String name,
            String lastName,
            String birthDay,
            String address,
            double maxQuote
    ) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.address = address;
        this.maxQuote = BigDecimal.valueOf(maxQuote);
    }

    @Override
    public String toString() {
        return STR."Client Name: \{this.getName()} \{this.getLastName()}\n"
                + STR."id: \{this.id}\nMax quote: \{this.maxQuote} ";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getMaxQuote() {
        return maxQuote.doubleValue();
    }

    public void setMaxQuote(Double maxQuote) {
        this.maxQuote = BigDecimal.valueOf(maxQuote);
    }
}
