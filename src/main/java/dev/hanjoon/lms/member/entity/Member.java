package dev.hanjoon.lms.member.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Member implements MemberCode {
    @Id
    private String userId;
    private String userName;
    private String phone;
    private String password;
    private LocalDateTime regDt;
    private LocalDateTime udtDt;//회원정보 수정일
    private boolean emailAuthYn;
    private LocalDateTime emailAuthDt;
    private String emailAuthKey;
    private String resetPasswordKey;
    private LocalDateTime resetPasswordLimitDt;
    private boolean adminYn;
    private String userStatus;//이용가능한상태, 정지상태
    private String zipcode;
    private String addr;
    private String addrDetail;
    private LocalDateTime lastLoginDt;

    public void setLastLoginDt(LocalDateTime lastLoginDateTime) {
        this.lastLoginDt = lastLoginDateTime;
    }
}
