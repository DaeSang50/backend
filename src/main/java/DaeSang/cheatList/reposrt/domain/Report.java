package DaeSang.cheatList.reposrt.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Report {

    // 용의자 정보
    private boolean know;
    private String suspectName;
    private String suspectPhone;
    private Gender suspectGender;
    private String suspectInfo;
    private String suspectAccountNum;
    private String suspectBankName;

    // 피해자 정보
    private String victimName;
    private String victimPhone;
    private String victimEmail;
    private String victimBankName;
    private String victimAccountNum;

    // 사건 정보
    private String deposit; // 입금 금액은 금액이므로 Long 타입 사용
    private LocalDate depositDate; // 입금일
    private String address;
    private String detailAddress;
    private String url;
    private String summary; // 사건 개요

    public enum Gender {
        MALE, FEMALE, OTHER;
    }
}