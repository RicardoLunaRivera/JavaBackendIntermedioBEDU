package org.bedu.veterinaria.mapper;

import javax.annotation.processing.Generated;
import org.bedu.veterinaria.dto.veterinarian_dto.CreateVeterinarianDTO;
import org.bedu.veterinaria.dto.veterinarian_dto.UpdateVeterinarianDTO;
import org.bedu.veterinaria.dto.veterinarian_dto.VeterinarianDTO;
import org.bedu.veterinaria.model.Veterinarian;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-05T17:10:34-0600",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.2.jar, environment: Java 17.0.8.1 (Amazon.com Inc.)"
)
@Component
public class VeterinarianMapperImpl implements VeterinarianMapper {

    @Override
    public VeterinarianDTO toDTO(Veterinarian model) {
        if ( model == null ) {
            return null;
        }

        VeterinarianDTO veterinarianDTO = new VeterinarianDTO();

        veterinarianDTO.setSchedule( model.getSchedule() );
        veterinarianDTO.setIdVeterinarian( model.getIdVeterinarian() );
        veterinarianDTO.setName( model.getName() );
        veterinarianDTO.setLastname( model.getLastname() );
        veterinarianDTO.setPhone( model.getPhone() );
        veterinarianDTO.setSpecialty( model.getSpecialty() );

        return veterinarianDTO;
    }

    @Override
    public Veterinarian toModel(CreateVeterinarianDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Veterinarian veterinarian = new Veterinarian();

        veterinarian.setName( dto.getName() );
        veterinarian.setLastname( dto.getLastname() );
        veterinarian.setSchedule( dto.getSchedule() );
        veterinarian.setPhone( dto.getPhone() );
        veterinarian.setSpecialty( dto.getSpecialty() );

        return veterinarian;
    }

    @Override
    public void updateVet(Veterinarian veterinarian, UpdateVeterinarianDTO data) {
        if ( data == null ) {
            return;
        }

        veterinarian.setName( data.getName() );
        veterinarian.setLastname( data.getLastname() );
        veterinarian.setSchedule( data.getSchedule() );
        veterinarian.setPhone( data.getPhone() );
        veterinarian.setSpecialty( data.getSpecialty() );
    }
}
