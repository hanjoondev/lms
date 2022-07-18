package dev.hanjoon.lms.banner.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dev.hanjoon.lms.banner.entity.Banner;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BannerDto {
    private long id;
    private String name;
    private String imgPath;
    private String alternativeTxt;
    private String url;
    private String target;
    private int bannerOrder;
    private boolean isVisible;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private long totalCount;
    private long seq;

    public static BannerDto of(Banner banner) {
        return BannerDto.builder()
                .id(banner.getId())
                .name(banner.getName())
                .imgPath(banner.getImgPath())
                .alternativeTxt(banner.getAlternativeTxt())
                .url(banner.getUrl())
                .target(banner.getTarget())
                .bannerOrder(banner.getBannerOrder())
                .isVisible(banner.isVisible())
                .createdAt(banner.getCreatedAt())
                .updatedAt(banner.getUpdatedAt())
                .build();
    }

    public static List<BannerDto> of(List<Banner> banners) {
        if (banners == null) {
            return null;
        }
        List<BannerDto> bannerList = new ArrayList<>();
        for(Banner x : banners) {
            bannerList.add(BannerDto.of(x));
        }
        return bannerList;
    }
}
