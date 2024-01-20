package org.bedu.veterinaria.service;

import jakarta.persistence.EntityNotFoundException;
import org.bedu.veterinaria.dto.petDTO.CreatePetDTO;
import org.bedu.veterinaria.dto.petDTO.DeletePetDTO;
import org.bedu.veterinaria.dto.petDTO.PetDTO;
import org.bedu.veterinaria.dto.petDTO.UpdatePetDTO;
import org.bedu.veterinaria.exception.PetNotFoundException;
import org.bedu.veterinaria.mapper.PetMapper;
import org.bedu.veterinaria.model.Owner;
import org.bedu.veterinaria.model.Pet;
import org.bedu.veterinaria.repository.OwnerRepository;
import org.bedu.veterinaria.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {
    @Autowired
    private PetRepository repository;

    private PetMapper mapper;

    @Autowired
    private OwnerRepository ownerRepository;

    public PetService(PetRepository repository, PetMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    //obtener a todos las mascotas
    public List<PetDTO> findAll(){
        return repository.findAll().stream().map(mapper::toDTO).toList();
    }

    //Crear una Mascota
    @Transactional
    public PetDTO save(CreatePetDTO data){
        Pet entity = repository.save(mapper.toModel(data));
        return mapper.toDTO(entity);
    }

    //Actualizar una Mascota
    public void updatePet(Long idPet, UpdatePetDTO data) throws PetNotFoundException{
        Optional<Pet> result = repository.findById(idPet);
        if (!result.isPresent()){
            throw new PetNotFoundException(idPet);
        }
        Pet pet = result.get();
        mapper.updatePet(pet,data);
        repository.save(pet);
    }


    //Eliminar una mascota
    public void deletePet(Long idPet , DeletePetDTO data) throws PetNotFoundException{
        Optional<Pet> result = repository.findById(idPet);
        if (!result.isPresent()){
            throw new PetNotFoundException(idPet);
        }
        Pet entity = result.get();
        mapper.deletePet(entity, data);
        repository.deleteById(idPet);
    }

    public void save(Pet pet) {
        repository.save(pet);
    }


}
