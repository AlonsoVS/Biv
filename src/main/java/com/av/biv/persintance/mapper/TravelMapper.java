package com.av.biv.persintance.mapper;

import com.av.biv.domain.Travel;
import com.av.biv.persintance.entity.TravelEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = TravelLocationMapper.class)
public interface TravelMapper {

  @Mapping(source = "locations", target = "locations")
  Travel toTravel(TravelEntity travel);

  List<Travel> toTravels(List<TravelEntity> travels);

  @InheritInverseConfiguration
  TravelEntity toTravelEntity(Travel travel);

  @InheritInverseConfiguration
  List<TravelEntity> toTravelsEntity(List<Travel> travels);
}
