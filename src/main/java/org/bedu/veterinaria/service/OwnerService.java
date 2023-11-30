package org.bedu.veterinaria.service;

import org.bedu.veterinaria.dto.CreateOwnerDTO;
import org.bedu.veterinaria.dto.OwnnerDTO;
import org.bedu.veterinaria.mapper.OwnerMapper;
import org.bedu.veterinaria.model.Owner;
import org.bedu.veterinaria.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {
    @Autowired
    private OwnerRepository repository;

    @Autowired
    private OwnerMapper mapper;

    public List<OwnnerDTO> findAll(){
        return repository.findAll().stream().map(mapper::toDTO).toList();
    }


    public OwnnerDTO save(CreateOwnerDTO data){
        Owner entity = repository.save(mapper.toModel(data));
        return mapper.toDTO(entity);
    }
}
