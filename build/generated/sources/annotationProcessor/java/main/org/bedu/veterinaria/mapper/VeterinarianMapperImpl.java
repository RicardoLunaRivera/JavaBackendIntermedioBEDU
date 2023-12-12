package org.bedu.veterinaria.mapper;

import java.util.Date;
import javax.annotation.processing.Generated;
import org.bedu.veterinaria.dto.veterinarianDTO.CreateVeterinarianDTO;
import org.bedu.veterinaria.dto.veterinarianDTO.UpdateVeterinarianDTO;
import org.bedu.veterinaria.dto.veterinarianDTO.VeterinarianDTO;
import org.bedu.veterinaria.model.Veterinarian;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-12T00:01:02-0600",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.4.jar, environment: Java 17.0.8.1 (Amazon.com Inc.)"
)
@Component
public class VeterinarianMapperImpl implements VeterinarianMapper {

    @Override
    public VeterinarianDTO toDTO(Veterinarian model) {
        if ( model == null ) {
            return null;
        }

        Long idVeterinarian = null;
        String name = null;
        String lastname = null;
        Date schedule = null;
        String phone = null;
        String specialty = null;

        idVeterinarian = model.getIdVeterinarian();
        name = model.getName();
        lastname = model.getLastname();
        schedule = model.getSchedule();
        phone = model.getPhone();
        specialty = model.getSpecialty();

        VeterinarianDTO veterinarianDTO = new VeterinarianDTO( idVeterinarian, name, lastname, schedule, phone, specialty );

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

        if ( data.getName() != null ) {
            veterinarian.setName( data.getName() );
        }
        if ( data.getLastname() != null ) {
            veterinarian.setLastname( data.getLastname() );
        }
        if ( data.getSchedule() != null ) {
            veterinarian.setSchedule( data.getSchedule() );
        }
        if ( data.getPhone() != null ) {
            veterinarian.setPhone( data.getPhone() );
        }
        if ( data.getSpecialty() != null ) {
            veterinarian.setSpecialty( data.getSpecialty() );
        }
    }
}
