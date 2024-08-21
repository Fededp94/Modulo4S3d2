package federicodipresa.dao;

import federicodipresa.entities.Event;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

@Entity
@Table(name = "eventi")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titolo;
    private LocalDateTime dataEvento;
    private String descrizione;

    @Enumerated(EnumType.STRING)
    private TipoEvento tipoEvento;
    private int numeroMassimoPartecipanti;

    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Partecipazione> partecipazioni = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private Location location;

}