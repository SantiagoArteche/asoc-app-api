package art.asoc.repository;

import art.asoc.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, String> {
    @Query(value = "SELECT * FROM client WHERE last_name = :lastName", nativeQuery = true)
    List<Client> findByLastName(@Param("lastName") String lastName);

    @Query(value = "SELECT * FROM client WHERE dni = :dni", nativeQuery = true)
    List<Client> findByDni(@Param("dni") String dni);
}
