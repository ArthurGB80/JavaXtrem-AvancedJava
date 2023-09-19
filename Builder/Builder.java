import models.Person;

import static models.Person.Builder.aPerson;

public class Builder {

    public static void main(String[] args) {
        Person p = aPerson()
                .withFirstname("Arthur")
                .withLastname("Brandi")
                .withPhone("123123123")
                .withEmail("arthurgularte@gmail.com")
                .build();


        if ("Brandi".equals(p.getLastname())) {
            System.out.println("Yes");
        }

    }

}