package org.bedu.veterinaria.service;

import org.bedu.veterinaria.dto.owner_dto.CreateOwnerDTO;
import org.bedu.veterinaria.dto.owner_dto.OwnerDTO;
import org.bedu.veterinaria.dto.owner_dto.UpdateOwnerDTO;
import org.bedu.veterinaria.exception.OwnerNotFoundException;
import org.bedu.veterinaria.mapper.OwnerMapper;
import org.bedu.veterinaria.model.Owner;
import org.bedu.veterinaria.repository.OwnerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerService {

    private final OwnerRepository repository;

    private final OwnerMapper mapper;

    public OwnerService(OwnerRepository repository, OwnerMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    //Obtener todos los clientes
    public List<OwnerDTO> findAll(){
        return repository.findAll().stream().map(mapper::toDTO).toList();
    }

    //Crear un nuevo cliente
    public OwnerDTO save(CreateOwnerDTO data){
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

    public Boolean deleteOwner(Long idOwner){
        try {
            repository.deleteById(idOwner);
            return true;
        } catch (Exception e){
            return false;
        }
    }

}
