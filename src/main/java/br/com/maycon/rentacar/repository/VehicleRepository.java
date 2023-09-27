package br.com.maycon.rentacar.repository;

import br.com.maycon.rentacar.model.VehicleModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<VehicleModel, Integer> {
}
