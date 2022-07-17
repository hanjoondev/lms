package dev.hanjoon.lms.admin.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class MemberParam extends CommonParam {
    String userId;
}
