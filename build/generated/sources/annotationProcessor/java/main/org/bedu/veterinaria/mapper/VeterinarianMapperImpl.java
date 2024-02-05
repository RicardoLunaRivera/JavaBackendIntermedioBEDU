package org.bedu.veterinaria.mapper;

import javax.annotation.processing.Generated;
import org.bedu.veterinaria.dto.veterinarianDTO.CreateVeterinarianDTO;
import org.bedu.veterinaria.dto.veterinarianDTO.UpdateVeterinarianDTO;
import org.bedu.veterinaria.dto.veterinarianDTO.VeterinarianDTO;
import org.bedu.veterinaria.model.Veterinarian;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-02T19:36:04-0600",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.4.jar, environment: Java 17.0.10 (Oracle Corporation)"
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
        String schedule = null;
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

        veterinarian.setName( data.getName() );
        veterinarian.setLastname( data.getLastname() );
        veterinarian.setSchedule( data.getSchedule() );
        veterinarian.setPhone( data.getPhone() );
        veterinarian.setSpecialty( data.getSpecialty() );
    }
}
