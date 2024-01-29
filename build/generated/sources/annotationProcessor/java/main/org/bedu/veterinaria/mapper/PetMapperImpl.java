package org.bedu.veterinaria.mapper;

import javax.annotation.processing.Generated;
import org.bedu.veterinaria.dto.petDTO.CreatePetDTO;
import org.bedu.veterinaria.dto.petDTO.DeletePetDTO;
import org.bedu.veterinaria.dto.petDTO.PetDTO;
import org.bedu.veterinaria.dto.petDTO.UpdatePetDTO;
import org.bedu.veterinaria.model.Owner;
import org.bedu.veterinaria.model.Pet;
import org.bedu.veterinaria.model.Veterinarian;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-29T10:18:24-0600",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.4.jar, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class PetMapperImpl implements PetMapper {

    @Override
    public PetDTO toDTO(Pet model) {
        if ( model == null ) {
            return null;
        }

        PetDTO petDTO = new PetDTO();

        petDTO.setOwnerId( modelOwnerIdOwner( model ) );
        petDTO.setVeterinarianId( modelVeterinarianIdVeterinarian( model ) );
        petDTO.setIdPet( model.getIdPet() );
        petDTO.setName( model.getName() );
        petDTO.setSpecies( model.getSpecies() );
        petDTO.setRace( model.getRace() );
        petDTO.setBirthDate( model.getBirthDate() );

        return petDTO;
    }

    @Override
    public Pet toModel(CreatePetDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Pet pet = new Pet();

        pet.setOwner( createPetDTOToOwner( dto ) );
        pet.setVeterinarian( createPetDTOToVeterinarian( dto ) );
        pet.setName( dto.getName() );
        pet.setSpecies( dto.getSpecies() );
        pet.setRace( dto.getRace() );
        pet.setBirthDate( dto.getBirthDate() );

        return pet;
    }

    @Override
    public void updatePet(Pet pet, UpdatePetDTO data) {
        if ( data == null ) {
            return;
        }

        if ( pet.getOwner() == null ) {
            pet.setOwner( new Owner() );
        }
        updatePetDTOToOwner( data, pet.getOwner() );
        if ( pet.getVeterinarian() == null ) {
            pet.setVeterinarian( new Veterinarian() );
        }
        updatePetDTOToVeterinarian( data, pet.getVeterinarian() );
        pet.setName( data.getName() );
        pet.setSpecies( data.getSpecies() );
        pet.setRace( data.getRace() );
        pet.setBirthDate( data.getBirthDate() );
    }

    @Override
    public void deletePet(Pet pet, DeletePetDTO data) {
        if ( data == null ) {
            return;
        }

        if ( pet.getOwner() == null ) {
            pet.setOwner( new Owner() );
        }
        deletePetDTOToOwner( data, pet.getOwner() );
        if ( pet.getVeterinarian() == null ) {
            pet.setVeterinarian( new Veterinarian() );
        }
        deletePetDTOToVeterinarian( data, pet.getVeterinarian() );
        pet.setIdPet( data.getIdPet() );
        pet.setName( data.getName() );
        pet.setSpecies( data.getSpecies() );
        pet.setRace( data.getRace() );
        pet.setBirthDate( data.getBirthDate() );
    }

    private Long modelOwnerIdOwner(Pet pet) {
        if ( pet == null ) {
            return null;
        }
        Owner owner = pet.getOwner();
        if ( owner == null ) {
            return null;
        }
        Long idOwner = owner.getIdOwner();
        if ( idOwner == null ) {
            return null;
        }
        return idOwner;
    }

    private Long modelVeterinarianIdVeterinarian(Pet pet) {
        if ( pet == null ) {
            return null;
        }
        Veterinarian veterinarian = pet.getVeterinarian();
        if ( veterinarian == null ) {
            return null;
        }
        Long idVeterinarian = veterinarian.getIdVeterinarian();
        if ( idVeterinarian == null ) {
            return null;
        }
        return idVeterinarian;
    }

    protected Owner createPetDTOToOwner(CreatePetDTO createPetDTO) {
        if ( createPetDTO == null ) {
            return null;
        }

        Owner owner = new Owner();

        owner.setIdOwner( createPetDTO.getOwnerId() );

        return owner;
    }

    protected Veterinarian createPetDTOToVeterinarian(CreatePetDTO createPetDTO) {
        if ( createPetDTO == null ) {
            return null;
        }

        Veterinarian veterinarian = new Veterinarian();

        veterinarian.setIdVeterinarian( createPetDTO.getVeterinarianId() );

        return veterinarian;
    }

    protected void updatePetDTOToOwner(UpdatePetDTO updatePetDTO, Owner mappingTarget) {
        if ( updatePetDTO == null ) {
            return;
        }

        mappingTarget.setIdOwner( updatePetDTO.getOwnerId() );
    }

    protected void updatePetDTOToVeterinarian(UpdatePetDTO updatePetDTO, Veterinarian mappingTarget) {
        if ( updatePetDTO == null ) {
            return;
        }

        mappingTarget.setIdVeterinarian( updatePetDTO.getVeterinarianId() );
    }

    protected void deletePetDTOToOwner(DeletePetDTO deletePetDTO, Owner mappingTarget) {
        if ( deletePetDTO == null ) {
            return;
        }

        mappingTarget.setIdOwner( deletePetDTO.getOwnerId() );
    }

    protected void deletePetDTOToVeterinarian(DeletePetDTO deletePetDTO, Veterinarian mappingTarget) {
        if ( deletePetDTO == null ) {
            return;
        }

        mappingTarget.setIdVeterinarian( deletePetDTO.getVeterinarianId() );
    }
}
