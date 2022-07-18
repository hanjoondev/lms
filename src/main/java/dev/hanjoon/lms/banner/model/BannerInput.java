package dev.hanjoon.lms.banner.model;

import lombok.Data;

@Data
public class BannerInput {
    private long id;
    private String name;
    private String imgPath;
    private String alternativeTxt;
    private String url;
    private String target;
    private int bannerOrder;
    private boolean isVisible;
    private String idList;
}
