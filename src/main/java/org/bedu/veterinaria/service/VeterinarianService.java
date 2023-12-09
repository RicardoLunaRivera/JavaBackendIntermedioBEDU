package org.bedu.veterinaria.service;

import org.bedu.veterinaria.dto.CreateVeterinarianDTO;
import org.bedu.veterinaria.dto.UpdateVeterinarianDTO;
import org.bedu.veterinaria.dto.VeterinarianDTO;
import org.bedu.veterinaria.mapper.VeterinarianMapper;
import org.bedu.veterinaria.model.Veterinarian;
import org.bedu.veterinaria.repository.VeterinarianRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VeterinarianService {
    @Autowired
    private VeterinarianRepository repository;
    
    @Autowired
    private VeterinarianMapper mapper;

    public VeterinarianService (VeterinarianRepository repository, VeterinarianMapper maper){
        this.repository = repository;
        this.mapper = maper;
    }

    public List<VeterinarianDTO> findAll(){
        return repository.findAll().stream().map(mapper::toDTO).toList();
    }

    public VeterinarianDTO save(CreateVeterinarianDTO data){
        Veterinarian entity =repository.save(mapper.toModel(data));
        return mapper.toDTO(entity);
    }

     public VeterinarianDTO updateById(Long idVeterinarian, UpdateVeterinarianDTO data){
        data.setIdVeterinarian(idVeterinarian);
        Veterinarian entity = repository.save(mapper.toModel(data));
        return mapper.toDTO(entity);
    }

    public Boolean deleteVeterinarian(Long idVeterinarian){
        try {
            repository.deleteById(idVeterinarian);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
