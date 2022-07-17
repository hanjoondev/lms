package dev.hanjoon.lms.course.model;

import dev.hanjoon.lms.admin.model.CommonParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class TakeCourseParam extends CommonParam {
    long id;
    String status;
    String userId;
    long searchCourseId;
}
