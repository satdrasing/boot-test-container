package com.satendra.testcontainer;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository  extends ListCrudRepository<VehicleEntity, Long> {
}
