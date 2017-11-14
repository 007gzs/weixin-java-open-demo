package com.github.binarywang.demo.wechat.service;

import com.github.binarywang.demo.wechat.config.RedisProperies;
import com.github.binarywang.demo.wechat.config.WechatOpenProperties;
import me.chanjar.weixin.open.api.impl.WxOpenInRedisConfigStorage;
import me.chanjar.weixin.open.api.impl.WxOpenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPool;

import javax.annotation.PostConstruct;
/**
 * @author <a href="https://github.com/007gzs">007</a>
 */
@Service
@EnableConfigurationProperties({WechatOpenProperties.class, RedisProperies.class})
public class WxOpenServiceDemo extends WxOpenServiceImpl {
    @Autowired
    private WechatOpenProperties wechatOpenProperties;
    @Autowired
    private RedisProperies redisProperies;
    private static JedisPool pool;

    @PostConstruct
    public void init() {
        WxOpenInRedisConfigStorage inRedisConfigStorage = new WxOpenInRedisConfigStorage(getJedisPool());
        inRedisConfigStorage.setComponentAppId(wechatOpenProperties.getComponentAppId());
        inRedisConfigStorage.setComponentAppSecret(wechatOpenProperties.getComponentSecret());
        inRedisConfigStorage.setComponentToken(wechatOpenProperties.getComponentToken());
        inRedisConfigStorage.setComponentAesKey(wechatOpenProperties.getComponentAesKey());
        setWxOpenConfigStorage(inRedisConfigStorage);
    }

    private JedisPool getJedisPool() {
        if (pool == null) {
            synchronized (WxOpenServiceDemo.class) {
                if (pool == null) {
                    pool = new JedisPool(redisProperies, redisProperies.getHost(),
                            redisProperies.getPort(), redisProperies.getConnectionTimeout(),
                            redisProperies.getSoTimeout(), redisProperies.getPassword(),
                            redisProperies.getDatabase(), redisProperies.getClientName(),
                            redisProperies.isSsl(), redisProperies.getSslSocketFactory(),
                            redisProperies.getSslParameters(), redisProperies.getHostnameVerifier());
                }
            }
        }
        return pool;
    }
}
