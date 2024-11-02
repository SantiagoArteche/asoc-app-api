package art.asoc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Date;

@Entity
@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotBlank(message = "El dni es requerido")
    private String dni;

    @NotBlank(message = "El nombre es requerido")
    private String name;

    @NotBlank(message = "El apellido es requerido")
    private String lastName;

    @NotBlank(message = "El Grupo Familiar es requerido")
    private String familyGroup;

    @NotBlank(message = "La dirección es requerida")
    private String address;

    @NotBlank(message = "El teléfono es requerido")
    private String phone;

    private String merch;

    private String clothes;

    private String shoes;

    private String microCredit;

    @NotBlank(message = "El numero de cuota es requerido")
    private String debtNumber;

    private String others;

    private Date date;

    @PrePersist
    private void timeNow(){
        this.date = new Date();
    }

}
