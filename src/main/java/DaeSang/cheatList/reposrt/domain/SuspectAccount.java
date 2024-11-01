package DaeSang.cheatList.reposrt.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "SUSPECT_ACCOUNT")
public class SuspectAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long suspectAccountId;

    @ManyToOne
    @JoinColumn(name = "suspect_id")
    private Suspect suspect;

    @Column(name = "bank_name", length = 20)
    private String bankName;

    @Column(name = "account_num", length = 30)
    private String accountNum;

    private Boolean know;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

}
