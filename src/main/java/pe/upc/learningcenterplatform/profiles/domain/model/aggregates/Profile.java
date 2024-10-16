package pe.upc.learningcenterplatform.profiles.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pe.upc.learningcenterplatform.profiles.domain.model.commands.CreateProfileCommand;
import pe.upc.learningcenterplatform.profiles.domain.model.valueobjects.EmailAddress;
import pe.upc.learningcenterplatform.profiles.domain.model.valueobjects.PersonName;
import pe.upc.learningcenterplatform.profiles.domain.model.valueobjects.StreetAddress;
import pe.upc.learningcenterplatform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

@Entity
@Getter
@Setter
public class Profile extends AuditableAbstractAggregateRoot<Profile> {

    @Embedded
    private PersonName name;

    @Embedded
    EmailAddress email;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "address_street")),
            @AttributeOverride(name = "number", column = @Column(name = "address_number")),
            @AttributeOverride(name = "city", column = @Column(name = "address_city")),
            @AttributeOverride(name = "postalCode", column = @Column(name = "address_postalCode")),
            @AttributeOverride(name = "country", column = @Column(name = "address_country")),
    })
    private StreetAddress address;

    public Profile() {
    }

    public Profile(String firstName, String lastName, String email, String street, String number, String city, String postalCode, String country) {
        this.name = new PersonName(firstName, lastName);
        this.email = new EmailAddress(email);
        this.address = new StreetAddress(street, number, city, postalCode, country);
    }

    public Profile(CreateProfileCommand command) {
        this();
        this.name = new PersonName(command.firstName(), command.lastName());
        this.email = new EmailAddress(command.email());
        this.address = new StreetAddress(
                command.street(),
                command.number(),
                command.city(),
                command.postalCode(),
                command.country()
        );
    }

    public String getFullName() {
        return name.getFullName();
    }

    public String getStreetAddress() {
        return address.getStreetAddress();
    }

    public String getEmailAddress() {
        return email.address();
    }
}
