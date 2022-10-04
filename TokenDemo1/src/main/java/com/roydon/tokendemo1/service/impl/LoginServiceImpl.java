package com.roydon.tokendemo1.service.impl;

import com.roydon.tokendemo1.common.ResponseResult;
import com.roydon.tokendemo1.entity.LoginUser;
import com.roydon.tokendemo1.entity.User;
import com.roydon.tokendemo1.service.LoginServcie;
import com.roydon.tokendemo1.utils.JwtUtil;
import com.roydon.tokendemo1.utils.RedisCache;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Objects;

import static com.roydon.tokendemo1.common.CodeConstants.CODE_200;
import static com.roydon.tokendemo1.utils.RedisConstants.LOGIN_KEY;

@Service
public class LoginServiceImpl implements LoginServcie {

    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private RedisCache redisCache;

    /**
     * 用户登录
     * 1.根据用户信息获取 Authentication
     * 2.根据用户 id 生成 jwt token
     * 3.存入 redis
     * 4.token 响应给前端
     *
     * @param user 登录用户
     * @return ResponseResult(CODE_200, " 登陆成功 ", map)
     */
    @Override
    public ResponseResult login(User user) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        if (Objects.isNull(authenticate)) {
            throw new RuntimeException("用户名或密码错误");
        }
        //使用userid生成token
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userId = loginUser.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(userId);
        //authenticate存入redis
        redisCache.setCacheObject(LOGIN_KEY + userId, loginUser);
        //把token响应给前端
        HashMap<String, String> map = new HashMap<>();
        map.put("token", jwt);
        return new ResponseResult(CODE_200, "登陆成功", map);
    }

    /**
     * 退出登录
     * 1.获取用户信息 SecurityContextHolder.getContext().getAuthentication();
     * 2.通过用户 id 清除 redis
     *
     * @return ResponseResult(CODE_200, "退出成功");
     */
    @Override
    public ResponseResult logout() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Long userid = loginUser.getUser().getId();
        redisCache.deleteObject(LOGIN_KEY + userid);
        return new ResponseResult(CODE_200, "退出成功");
    }

}
