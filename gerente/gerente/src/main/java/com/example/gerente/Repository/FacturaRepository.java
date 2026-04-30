import com.ejemplo.ms_persona.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long> {

    Optional<Factura> findByid_factura(long id_factura);

    boolean existsByfecha(Date fecha);

    Optional<Factura> findBytotal(int total);
}