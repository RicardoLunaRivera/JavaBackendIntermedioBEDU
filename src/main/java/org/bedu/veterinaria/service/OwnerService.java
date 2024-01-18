package org.bedu.veterinaria.service;

import jakarta.validation.Valid;
import org.bedu.veterinaria.dto.ownerDTO.CreateOwnerDTO;
import org.bedu.veterinaria.dto.ownerDTO.OwnerDTO;
import org.bedu.veterinaria.dto.ownerDTO.UpdateOwnerDTO;
import org.bedu.veterinaria.exception.OwnerNotFoundException;
import org.bedu.veterinaria.mapper.OwnerMapper;
import org.bedu.veterinaria.model.Owner;
import org.bedu.veterinaria.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerService {
    @Autowired
    private OwnerRepository repository;

    @Autowired
    private OwnerMapper mapper;

    public OwnerService(OwnerRepository repository, OwnerMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    //Obtener todos los clientes
    public List<OwnerDTO> findAll() {
        return repository.findAll().stream().map(mapper::toDTO).toList();
    }

    //Crear un nuevo cliente
    public OwnerDTO save(@Valid CreateOwnerDTO data) {
        Owner entity = repository.save(mapper.toModel(data));
        return mapper.toDTO(entity);
    }

    //Actualiza un cliente existente
    public void updateOwner(long idOwner, UpdateOwnerDTO data) throws OwnerNotFoundException{
        Optional<Owner> result = repository.findById(idOwner);
        if(!result.isPresent()){
            throw new OwnerNotFoundException(idOwner);
        }
        Owner owner = result.get();
        mapper.updateOwner(owner,data);
        repository.save(owner);
    }

    public Owner findById(Owner owner) {
        return repository.findById(owner.getIdOwner()).orElse(null);
    }

    public void update(Owner owner){
        repository.save(owner);
    }

    public void delete(Owner owner) {
        repository.delete(owner);
    }

    public List<Owner> findByPalabra(String palabra) {
        if(palabra != null){
            return repository.findByPalabra(palabra);
        }
        return repository.findAll();
    }


//    public OwnerDTO updateById(Long idOwner, UpdateOwnerDTO data){
//        data.setIdOwner(idOwner);
//        Owner entity = repository.save(mapper.toModel(data));
//        return mapper.toDTO(entity);
//    }

    //Borra un cliente

//    public void deleteOwner(long idOwner, DeleteOwnerDTO data) throws OwnerNotFoundException{
//        Optional<Owner> result = repository.findById(idOwner);
//        if(!result.isPresent()){
//            throw new OwnerNotFoundException(idOwner);
//        }
//        Owner entity = result.get();
//        mapper.deleteOwner(entity,data);
//        repository.deleteById(idOwner);
//    }


    public Boolean deleteOwner(Long idOwner) {
        try {
            repository.deleteById(idOwner);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
