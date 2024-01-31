package org.bedu.veterinaria.service;

import org.bedu.veterinaria.dto.ownerDTO.UpdateOwnerDTO;
import org.bedu.veterinaria.dto.veterinarianDTO.CreateVeterinarianDTO;
import org.bedu.veterinaria.dto.veterinarianDTO.UpdateVeterinarianDTO;
import org.bedu.veterinaria.dto.veterinarianDTO.VeterinarianDTO;
import org.bedu.veterinaria.exception.OwnerNotFoundException;
import org.bedu.veterinaria.exception.VeterinarianNotFoundException;
import org.bedu.veterinaria.mapper.VeterinarianMapper;
import org.bedu.veterinaria.model.Owner;
import org.bedu.veterinaria.model.Veterinarian;
import org.bedu.veterinaria.repository.VeterinarianRepository;

import java.util.List;
import java.util.Optional;

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

//     public VeterinarianDTO updateById(Long idVeterinarian, UpdateVeterinarianDTO data){
//        data.setIdVeterinarian(idVeterinarian);
//        Veterinarian entity = repository.save(mapper.toModel(data));
//        return mapper.toDTO(entity);
//    }

    public void updateVet(long idVeterinarian, UpdateVeterinarianDTO data) throws VeterinarianNotFoundException{
        Optional<Veterinarian> result = repository.findById(idVeterinarian);
        if(!result.isPresent()){
            throw new VeterinarianNotFoundException(idVeterinarian);
        }
        Veterinarian veterinarian = result.get();
        mapper.updateVet(veterinarian,data);
        repository.save(veterinarian);
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
