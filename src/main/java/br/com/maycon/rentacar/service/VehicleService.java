package br.com.maycon.rentacar.service;

import br.com.maycon.rentacar.dto.CustomerDTO;
import br.com.maycon.rentacar.dto.VehicleDTO;
import br.com.maycon.rentacar.exception.ResourceNotFoundException;
import br.com.maycon.rentacar.mapper.CustomerModelMapper;
import br.com.maycon.rentacar.model.CustomerModel;
import br.com.maycon.rentacar.model.VehicleModel;
import br.com.maycon.rentacar.repository.CustomerRepository;
import br.com.maycon.rentacar.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository repository;

    public VehicleDTO create(VehicleDTO dto){
        VehicleModel model = CustomerModelMapper.parseObject(dto,VehicleModel.class);
        return CustomerModelMapper.parseObject(repository.save(model), VehicleDTO.class);
    }

    public VehicleDTO findById(int id){
        VehicleModel model = repository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException(null));
        return CustomerModelMapper.parseObject(model, VehicleDTO.class);
    }

    public List<VehicleDTO> findAll(){
        List<VehicleModel> list = repository.findAll();
        return CustomerModelMapper.parseObjectList(list, VehicleDTO.class);
    }

    public VehicleDTO update(VehicleDTO dto){
        VehicleModel model = repository.findById(dto.getId()).orElseThrow(()-> new
                ResourceNotFoundException(null));
        model = CustomerModelMapper.parseObject(dto, VehicleModel.class);
        return CustomerModelMapper.parseObject(repository.save(model),
                VehicleDTO.class);
    }

    public void delete(VehicleDTO dto){
        VehicleModel model = repository.findById(dto.getId()).orElseThrow(() -> new
                ResourceNotFoundException(null));
        repository.delete(model);
    }
}
