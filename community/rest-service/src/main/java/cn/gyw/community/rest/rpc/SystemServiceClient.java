package cn.gyw.community.rest.rpc;

import org.springframework.cloud.openfeign.FeignClient;

import cn.gyw.community.system.api.ISysUserServiceAPi;

@FeignClient(name = "community-system", url = "http://localhost:8081/system/user")
public interface SystemServiceClient extends ISysUserServiceAPi {

}
