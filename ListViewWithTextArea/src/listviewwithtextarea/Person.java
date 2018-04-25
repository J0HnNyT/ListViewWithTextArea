/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listviewwithtextarea;

/**
 *
 * @author johntaylor
 */
public class Person {
    
    private String firstName;
    private String lastName;
    private String personalHobbies;

    public Person(String firstName, String lastName, String personalHobbies) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalHobbies = personalHobbies;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPersonalHobbies() {
        return personalHobbies;
    }

    public void setPersonalHobbies(String personalHobbies) {
        this.personalHobbies = personalHobbies;
    }

    @Override
    public String toString() {
        return String.format("firstName=" + firstName + "\nlastName=" + lastName 
                + "\n\tpersonalHobbies=" + personalHobbies);
    }
    
    
        
    
    
}
