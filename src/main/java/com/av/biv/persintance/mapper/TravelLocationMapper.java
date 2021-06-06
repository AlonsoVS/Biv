package com.av.biv.persintance.mapper;

import com.av.biv.domain.TravelLocation;
import com.av.biv.domain.User;
import com.av.biv.persintance.entity.TravelLocationEntity;
import com.av.biv.persintance.entity.UserEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = NoteMapper.class)
public interface TravelLocationMapper {

  @Mapping(source = "notes", target = "notes")
  TravelLocation toTravelLocation(TravelLocationEntity travelLocation);

  List<TravelLocation> toTravelLocations(List<TravelLocationEntity> travelLocations);

  @InheritInverseConfiguration
  TravelLocationEntity toTravelLocationEntity(TravelLocation travelLocation);

  @InheritInverseConfiguration
  List<TravelLocationEntity> toTravelLocationsEntity(List<TravelLocation> travelLocations);
}
