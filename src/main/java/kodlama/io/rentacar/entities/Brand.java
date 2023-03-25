package kodlama.io.rentacar.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="brands")//snake_case
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //@Column(name="")
    private String name;
}
