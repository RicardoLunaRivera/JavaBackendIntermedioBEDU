package org.bedu.veterinaria.service;


import org.bedu.veterinaria.dto.veterinarian_dto.CreateVeterinarianDTO;
import org.bedu.veterinaria.dto.veterinarian_dto.UpdateVeterinarianDTO;
import org.bedu.veterinaria.dto.veterinarian_dto.VeterinarianDTO;
import org.bedu.veterinaria.exception.VeterinarianNotFoundException;
import org.bedu.veterinaria.mapper.VeterinarianMapper;
import org.bedu.veterinaria.model.Veterinarian;
import org.bedu.veterinaria.repository.VeterinarianRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class VeterinarianService {

    private final VeterinarianRepository repository;

    private final VeterinarianMapper mapper;

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


    //Metodos para las vistas en thymeleaf
    public Veterinarian findById(Veterinarian veterinarian) {
        return repository.findById(veterinarian.getIdVeterinarian()).orElse(null);
    }

    public void update(Veterinarian veterinarian){
        repository.save(veterinarian);
    }

    public List<Veterinarian> findByPalabra(String palabra) {
        if(palabra != null){
            return repository.findByPalabra(palabra);
        }
        return repository.findAll();
    }

    public void delete(Veterinarian veterinarian) {
        repository.delete(veterinarian);
    }
}
