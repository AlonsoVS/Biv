package com.av.biv.persintance.mapper;

import com.av.biv.domain.Travel;
import com.av.biv.persintance.entity.TravelEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {TravelLocationMapper.class, NoteMapper.class})
public interface TravelMapper {

  @Mappings({
          @Mapping(source = "locations", target = "locations"),
          @Mapping(source = "notes", target = "notes")
  })
  Travel toTravel(TravelEntity travel);

  List<Travel> toTravels(List<TravelEntity> travels);

  @InheritInverseConfiguration
  TravelEntity toTravelEntity(Travel travel);

  @InheritInverseConfiguration
  List<TravelEntity> toTravelsEntity(List<Travel> travels);
}
