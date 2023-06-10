package cn.gyw.springboot.webmvc.service;

public interface UserService {
    long countFansCountByUserId(Long userId);

    long countMsgCountByUserId(Long userId);

    long countCollectCountByUserId(Long userId);

    long countFollowCountByUserId(Long userId);

    long countRedBagCountByUserId(Long userId);

    long countCouponCountByUserId(Long userId);
}
