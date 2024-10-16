package pe.upc.learningcenterplatform.profiles.domain.services;

import pe.upc.learningcenterplatform.profiles.domain.model.aggregates.Profile;
import pe.upc.learningcenterplatform.profiles.domain.model.queries.GetAllProfilesQuery;
import pe.upc.learningcenterplatform.profiles.domain.model.queries.GetProfileByEmailQuery;
import pe.upc.learningcenterplatform.profiles.domain.model.queries.GetProfileByIdQuery;

import java.util.List;
import java.util.Optional;

public interface ProfileQueryService {

    Optional<Profile> handle(GetProfileByEmailQuery query);

    Optional<Profile> handle(GetProfileByIdQuery query);

    List<Profile> handle(GetAllProfilesQuery query);

}
