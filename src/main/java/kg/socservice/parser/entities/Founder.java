package kg.socservice.parser.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "founder")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Founder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "FIO", columnDefinition = "TEXT")
    String FIO;

    @ManyToOne
    @JoinColumn(name = "founder_jurLicoOrFilial")
    JurLicoOrFilial jurLicoOrFilial;
}
