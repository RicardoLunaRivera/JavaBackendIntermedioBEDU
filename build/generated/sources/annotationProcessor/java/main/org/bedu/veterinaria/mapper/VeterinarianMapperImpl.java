package org.bedu.veterinaria.mapper;

import java.text.SimpleDateFormat;
import javax.annotation.processing.Generated;
import org.bedu.veterinaria.dto.veterinarian_dto.CreateVeterinarianDTO;
import org.bedu.veterinaria.dto.veterinarian_dto.UpdateVeterinarianDTO;
import org.bedu.veterinaria.dto.veterinarian_dto.VeterinarianDTO;
import org.bedu.veterinaria.model.Veterinarian;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-05T19:01:37-0600",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.5.jar, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class VeterinarianMapperImpl implements VeterinarianMapper {

    @Override
    public VeterinarianDTO toDTO(Veterinarian model) {
        if ( model == null ) {
            return null;
        }

        VeterinarianDTO veterinarianDTO = new VeterinarianDTO();

        if ( model.getSchedule() != null ) {
            veterinarianDTO.setSchedule( new SimpleDateFormat().format( model.getSchedule() ) );
        }
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

        if ( dto.getSchedule() != null ) {
            veterinarian.setSchedule( new SimpleDateFormat().format( dto.getSchedule() ) );
        }
        veterinarian.setName( dto.getName() );
        veterinarian.setLastname( dto.getLastname() );
        veterinarian.setPhone( dto.getPhone() );
        veterinarian.setSpecialty( dto.getSpecialty() );

        return veterinarian;
    }

    @Override
    public void updateVet(Veterinarian veterinarian, UpdateVeterinarianDTO data) {
        if ( data == null ) {
            return;
        }

        if ( data.getSchedule() != null ) {
            veterinarian.setSchedule( new SimpleDateFormat().format( data.getSchedule() ) );
        }
        else {
            veterinarian.setSchedule( null );
        }
        veterinarian.setName( data.getName() );
        veterinarian.setLastname( data.getLastname() );
        veterinarian.setPhone( data.getPhone() );
        veterinarian.setSpecialty( data.getSpecialty() );
    }

    @Override
    public Veterinarian toModel(UpdateVeterinarianDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Veterinarian veterinarian = new Veterinarian();

        if ( dto.getSchedule() != null ) {
            veterinarian.setSchedule( new SimpleDateFormat().format( dto.getSchedule() ) );
        }
        veterinarian.setName( dto.getName() );
        veterinarian.setLastname( dto.getLastname() );
        veterinarian.setPhone( dto.getPhone() );
        veterinarian.setSpecialty( dto.getSpecialty() );

        return veterinarian;
    }
}
