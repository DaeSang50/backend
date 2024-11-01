package DaeSang.cheatList.reposrt.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "VICTIM")
public class Victim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long victimId;

    @Column(name = "victim_name", length = 20)
    private String victimName;

    @Column(name = "victim_phone", length = 20)
    private String victimPhone;

    @Column(name = "victim_email", length = 50)
    private String victimEmail;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

}
