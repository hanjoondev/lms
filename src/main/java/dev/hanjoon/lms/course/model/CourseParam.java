package dev.hanjoon.lms.course.model;

import dev.hanjoon.lms.admin.model.CommonParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class CourseParam extends CommonParam {
    long id;//course.id
    long categoryId;
}
