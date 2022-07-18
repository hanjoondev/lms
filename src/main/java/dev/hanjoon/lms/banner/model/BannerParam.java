package dev.hanjoon.lms.banner.model;

import dev.hanjoon.lms.admin.model.CommonParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class BannerParam extends CommonParam {
    long id;
}
