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

    public void setSuspectId(Long suspectId) {
        this.suspectId = suspectId;
    }

    public void setSuspectName(String suspectName) {
        this.suspectName = suspectName;
    }

    public void setSuspectPhone(String suspectPhone) {
        this.suspectPhone = suspectPhone;
    }

    public void setSuspectGender(Gender suspectGender) {
        this.suspectGender = suspectGender;
    }

    public void setSuspectInfo(String suspectInfo) {
        this.suspectInfo = suspectInfo;
    }

    public void setKnow(Boolean know) {
        this.know = know;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}

