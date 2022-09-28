package com.perekupapp.reporistories;

import com.perekupapp.models.CarAdvert;
import org.springframework.data.repository.CrudRepository;

public interface UsedCarsRepository extends CrudRepository<CarAdvert, Long> {

}
