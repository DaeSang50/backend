package DaeSang.cheatList.reposrt.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "VICTIM_ACCOUNT")
public class VictimAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long victimAccountId;

    @ManyToOne
    @JoinColumn(name = "victim_id")
    private Victim victim;

    @Column(name = "bank_name", length = 20)
    private String bankName;

    @Column(name = "account_num", length = 30)
    private String accountNum;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

}


