package com.roydon.tokendemo1.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.roydon.tokendemo1.entity.Menu;

import java.util.List;

public interface MenuMapper extends BaseMapper<Menu> {
    /**
     * 查询角色权限 perms
     *
     * @param userId
     * @return
     */
    List<String> selectPermsByUserId(Long userId);


}