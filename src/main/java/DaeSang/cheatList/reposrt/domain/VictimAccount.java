package DaeSang.cheatList.reposrt.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "VICTIM_ACCOUNT")
public class VictimAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long victimAccountId;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "victim_id")
    private Victim victim;

    @Column(name = "bank_name", length = 100)
    private String bankName;

    @Column(name = "account_num", length = 100)
    private String accountNum;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

}


