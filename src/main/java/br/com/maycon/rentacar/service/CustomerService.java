package br.com.maycon.rentacar.service;

import br.com.maycon.rentacar.dto.CustomerDTO;
import br.com.maycon.rentacar.exception.ResourceNotFoundException;
import br.com.maycon.rentacar.mapper.CustomerModelMapper;
import br.com.maycon.rentacar.model.CustomerModel;
import br.com.maycon.rentacar.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repository;

    public CustomerDTO create(CustomerDTO dto){
        CustomerModel model = CustomerModelMapper.parseObject(dto,CustomerModel.class);
        return CustomerModelMapper.parseObject(repository.save(model), CustomerDTO.class);
    }

    public CustomerDTO findById(int id){
        CustomerModel model = repository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException(null));
        return CustomerModelMapper.parseObject(model, CustomerDTO.class);
    }

    public List<CustomerDTO> findAll(){
        List<CustomerModel> list = repository.findAll();
        return CustomerModelMapper.parseObjectList(list, CustomerDTO.class);
    }

    public CustomerDTO update(CustomerDTO dto){
        CustomerModel model = repository.findById(dto.getId()).orElseThrow(()-> new
                ResourceNotFoundException(null));
        model = CustomerModelMapper.parseObject(dto, CustomerModel.class);
        return CustomerModelMapper.parseObject(repository.save(model),
                CustomerDTO.class);
    }

    public void delete(CustomerDTO dto){
        CustomerModel model = repository.findById(dto.getId()).orElseThrow(() -> new
                ResourceNotFoundException(null));
        repository.delete(model);
    }
}
