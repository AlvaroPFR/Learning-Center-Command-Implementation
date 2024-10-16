package pe.upc.learningcenterplatform.profiles.domain.model.valueobjects;


import jakarta.persistence.Embeddable;

@Embeddable
public record PersonName (String firstName, String lastName) {
    public PersonName() { this(null, null); }

    public PersonName {
        if (firstName == null || firstName.isBlank()) {
            throw new IllegalArgumentException("First name is required");
        }
        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("Last name is required");
        }
    }

    public String getFullName(){
        return String.format("%s %s", firstName, lastName);
    }
}
