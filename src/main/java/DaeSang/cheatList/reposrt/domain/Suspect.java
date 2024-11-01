package DaeSang.cheatList.reposrt.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "SUSPECT")
public class Suspect {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long suspectId;

    @Column(name = "suspect_name", length = 20)
    private String suspectName;

    @Column(name = "suspect_phone", length = 20)
    private String suspectPhone;

    @Enumerated(EnumType.STRING)
    @Column(name = "suspect_gender")
    private Gender suspectGender;

    @Column(name = "suspect_info")
    private String suspectInfo;

    private Boolean know;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public enum Gender {
        MALE, FEMALE, OTHER
    }

}

