package dev.hanjoon.lms.admin.model;

import lombok.Data;

@Data
public class MemberInput {
    String userId;
    String userStatus;
    String password;
}
