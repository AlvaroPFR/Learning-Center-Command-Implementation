package pe.upc.learningcenterplatform.profiles.domain.model.queries;

import pe.upc.learningcenterplatform.profiles.domain.model.valueobjects.EmailAddress;

public record GetProfileByEmailQuery(EmailAddress emailAddress) {
}
