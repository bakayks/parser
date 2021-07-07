package kg.socservice.parser.entities;

import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "jurlico_or_filial")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class JurLicoOrFilial {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "name", columnDefinition = "TEXT")
    String name;

    @Column(name = "registration_number")
    String regNumber;

    @Column(name = "status")
    String status;

    @Column(name = "INN")
    String INN;

    @Column(name = "code_okpo")
    String codeOkpo;

    @Column(name = "date")
    String date;
}
