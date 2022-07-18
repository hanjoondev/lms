package dev.hanjoon.lms.banner.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import dev.hanjoon.lms.banner.dto.BannerDto;
import dev.hanjoon.lms.banner.entity.Banner;
import dev.hanjoon.lms.banner.mapper.BannerMapper;
import dev.hanjoon.lms.banner.model.BannerInput;
import dev.hanjoon.lms.banner.model.BannerParam;
import dev.hanjoon.lms.banner.repository.BannerRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BannerService {
    private final BannerRepository bannerRepository;
    private final BannerMapper bannerMapper;

    public boolean add(BannerInput parameter) {
        Banner banner = Banner.builder()
                              .name(parameter.getName())
                              .imgPath(parameter.getImgPath())
                              .alternativeTxt(parameter.getAlternativeTxt())
                              .url(parameter.getUrl())
                              .target(parameter.getTarget())
                              .bannerOrder(parameter.getBannerOrder())
                              .isVisible(parameter.isVisible())
                              .build();
        bannerRepository.save(banner);
        return true;
    }

    public boolean set(BannerInput parameter) {
        Optional<Banner> optionalBanner = bannerRepository.findById(parameter.getId());
        if (!optionalBanner.isPresent()) {
            return false;
        }
        Banner banner = optionalBanner.get();
        banner.setName(parameter.getName());
        banner.setImgPath(parameter.getImgPath());
        banner.setAlternativeTxt(parameter.getAlternativeTxt());
        banner.setUrl(parameter.getUrl());
        banner.setTarget(parameter.getTarget());
        banner.setBannerOrder(parameter.getBannerOrder());
        banner.setVisible(parameter.isVisible());
        return true;
    }

    public List<BannerDto> list(BannerParam parameter) {
        List<BannerDto> list = bannerMapper.selectList(parameter);
        long totalCount = list.size();
        if (!CollectionUtils.isEmpty(list)) {
            int i = 0;
            for (BannerDto x : list) {
                x.setTotalCount(totalCount);
                x.setSeq(totalCount - parameter.getPageStart() - i);
                i++;
            }
        }
        return list;
    }

    public BannerDto getById(long id) {
        return bannerRepository.findById(id).map(BannerDto::of).orElse(null);
    }

    public boolean del(String bannerList) {
        if (bannerList != null && bannerList.length() > 0) {
            String[] ids = bannerList.split(",");
            for (String x : ids) {
                long id = 0L;
                try {
                    id = Long.parseLong(x);
                } catch (Exception e) {
                }
                if (id > 0) {
                    bannerRepository.deleteById(id);
                }
            }
        }
        return true;
    }

    public BannerDto getBannerById(long id) {
        Optional<Banner> b = bannerRepository.findById(id);
        if (b.isEmpty()) return BannerDto.builder().build();
        return BannerDto.of(b.get());
    }
}
