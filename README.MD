### 本Demo基于Spring Boot构建，实现微信三方平台开发功能。
### 本项目为weixin-java-tools的Demo演示程序，更多Demo请查阅：https://github.com/Wechat-Group/weixin-java-tools

[![Build Status](https://travis-ci.org/007gzs/weixin-java-open-demo.svg?branch=master)](https://travis-ci.org/007gzs/weixin-java-open-demo)
-----------------------

## 使用步骤：
1. 配置：修改`/src/main/resources/application.yml` ，根据自己需要填写相关配置（需要注意的是：yml文件内的属性冒号后面的文字之前需要加空格，可参考已有配置，否则属性会设置不成功）；	
1. 运行Java程序：`com.github.binarywang.demo.wechat.WxOpenDemoApplication`；
1. 配置微信三方平台中的授权事件接收URL：http://my-domain/notify/receive_ticket 
1. 配置微信三方平台中的公众号消息与事件接收URL http://my-domain/api/notify/$APPID$/callback
	
