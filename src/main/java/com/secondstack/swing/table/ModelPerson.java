/*
 * created : Nov 18, 2011
 * by : Latief
 */
package com.secondstack.swing.table;

import com.secondstack.swing.Person;

/**
 *
 * @author Latief
 */
public class ModelPerson {
    private String string;
    private Person person;
    private Boolean bool;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Boolean getBool() {
        return bool;
    }

    public void setBool(Boolean bool) {
        this.bool = bool;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ModelPerson other = (ModelPerson) obj;
        if ((this.string == null) ? (other.string != null) : !this.string.equals(other.string)) {
            return false;
        }
        if (this.person != other.person && (this.person == null || !this.person.equals(other.person))) {
            return false;
        }
        if (this.bool != other.bool) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + (this.string != null ? this.string.hashCode() : 0);
        hash = 73 * hash + (this.person != null ? this.person.hashCode() : 0);
        hash = 73 * hash + (this.bool ? 1 : 0);
        return hash;
    }

}
