package com.jingpaidang.tools.batch.service.user;

import com.jingpaidang.tools.batch.dao.user.UserMapper;
import com.jingpaidang.tools.batch.domain.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: JackChan
 * Date: 7/30/13
 * Time: 1:27 PM
 */
@Service("userService")
public class UserService {

    @Resource
    private UserMapper userMapper;

    public List<User> findAllUser() {
        return userMapper.findAllUser();
    }


}
