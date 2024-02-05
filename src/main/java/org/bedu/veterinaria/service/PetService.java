package org.bedu.veterinaria.service;

import org.bedu.veterinaria.dto.pet_dto.CreatePetDTO;
import org.bedu.veterinaria.dto.pet_dto.DeletePetDTO;
import org.bedu.veterinaria.dto.pet_dto.PetDTO;
import org.bedu.veterinaria.dto.pet_dto.UpdatePetDTO;

import org.bedu.veterinaria.exception.PetNotFoundException;
import org.bedu.veterinaria.mapper.PetMapper;
import org.bedu.veterinaria.model.Pet;
import org.bedu.veterinaria.repository.PetRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    private final PetRepository repository;
    private final PetMapper mapper;

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



    //Metodos para las vistas en thymeleaf
    public void save(Pet pet) {
        repository.save(pet);
    }

    public List<Pet> findAllpets() {
        return repository.findAll();
    }

    public Pet findById(Pet pet) {
        return repository.findById(pet.getIdPet()).orElse(null);
    }

    public void update(Pet pet){
        repository.save(pet);
    }

    public void delete(Pet pet) {
        repository.delete(pet);
    }

    public List<Pet> findByPalabra(String palabra) {
        if(palabra != null){
            return repository.findByPalabra(palabra);
        }
        return repository.findAll();
    }

}
