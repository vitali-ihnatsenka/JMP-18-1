package by.epam.jmp18.repository;

import by.epam.jmp18.domain.Unit;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by Vitali on 13.11.2016.
 */
@RepositoryRestResource(path = "unit")
public interface UnitRepository extends PagingAndSortingRepository<Unit, Long> {
}
