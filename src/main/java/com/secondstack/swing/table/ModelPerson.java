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
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
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
        if (this.person != other.person && (this.person == null || !this.person.equals(other.person))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + (this.person != null ? this.person.hashCode() : 0);
        return hash;
    }
}
