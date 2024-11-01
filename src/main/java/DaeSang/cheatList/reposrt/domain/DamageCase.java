package DaeSang.cheatList.reposrt.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;

@Entity
@Getter
@Table(name = "DAMAGE_CASE")
public class DamageCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long caseId;

    @ManyToOne
    @JoinColumn(name = "suspect_id")
    private Suspect suspect;

    @Column(name = "deposit", length = 20)
    private String deposit;

    @Column(name = "address", length = 100)
    private String address;

    @Column(name = "detail_address", length = 100)
    private String detailAddress;

    @Column(name = "url", length = 100)
    private String url;

    @Column(name = "deposit_date")
    private LocalDate depositDate;

    @Column(name = "summary")
    private String summary;

    @ManyToOne
    @JoinColumn(name = "suspect_account_id")
    private SuspectAccount suspectAccount;

    @ManyToOne
    @JoinColumn(name = "victim_id")
    private Victim victim;

    @ManyToOne
    @JoinColumn(name = "victim_account_id")
    private VictimAccount victimAccount;

    // Getters and Setters
}
