package org.xy.medicare.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.xy.medicare.dao.IUserDao;
import org.xy.medicare.entity.User;
import org.xy.medicare.service.IUserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:User类的服务层实现
 * @author: XY-GYL
 * @time: 2022/5/26 18:44
 */

@Service
public class UserServiceImpl extends ServiceImpl<IUserDao, User> implements IUserService {

    /**
     * 根据账号和密码验证登录并封装信息到res中
     *
     * @param account  账号
     * @param password 密码
     * @return 包含用户信息的Map
     */
    @Override
    public Map<String, String> userLoginSer(String account, String password) {
        Map<String, String> map = new HashMap<>();
        int res = query().eq("account", account).count();
        if (res == 0) {
            //账号不存在
            map.put("res", "-1");
            return map;
        }
        User user = query().eq("account", account).one();
        if (password.equals(user.getPassword())) {
            //密码相同
            map.put("res", "1");
            map.put("account", user.getAccount());
            map.put("user_role", user.getUserRole().toString());
        } else {
            //密码不同，登录失败
            map.put("res", "-2");
        }
        return map;
    }

    /**
     * 根据账号、密码和用户角色注册用户并封装信息到res中
     *
     * @param account  账号
     * @param password 密码
     * @param userRole 用户角色
     * @return 包含用户信息的Map
     */
    @Override
    public Map<String, String> userRegisterSer(String account, String password, Integer userRole) {
        Map<String, String> map = new HashMap<>();
        int res = query().eq("account", account).count();
        if (res >= 1) {
            //账号已注册
            map.put("res", "-1");
        } else {
            //账号未注册
            boolean suc = baseMapper.insertIntoUser(account, password, userRole);
            if (suc) {
                map.put("res", "1");
            } else {
                map.put("res", "2");
            }
        }
        return map;
    }

    /**
     * 根据账号判断是否存在账户
     *
     * @param account 账号
     * @return 用户数量
     */
    @Override
    public Integer countUserByAccountSer(String account) {
        return query().eq("account", account).count();
    }

    /**
     * 根据账号找到用户的用户角色
     *
     * @param account 账号
     * @return 用户角色
     */
    @Override
    public Integer findUserRoleByAccountSer(String account) {
        return baseMapper.selectUserRoleByAccount(account);
    }

    /**
     * 根据账号和密码修改密码
     *
     * @param account  账号
     * @param password 密码
     * @return 修改结果
     */
    @Override
    public boolean modifyPasswordSer(String account, String password) {
        return baseMapper.updatePasswordByAccount(account, password);
    }

    /**
     * 根据账号删除用户信息
     * @param account 账号
     * @return 删除结果
     */
    @Override
    public boolean deleteUserByAccountSer(String account){
        return baseMapper.deleteUserByAccountDAO(account);
    }

    /**
     * 查询除管理员外所有用户并分页显示
     *
     * @return 分页结果
     */
    @Override
    public PageInfo<Map<String, Object>> findAllUserExceptAdminInPagesSer(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Map<String, Object>> list = baseMapper.findAllUserExceptAdmin();
        //如果数据为空
        if(list.size()==0){
            return null;
        }
        //将用户角色的数字转为文字
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).get("user_role").equals(1)) {
                list.get(i).put("user_role", "审批人员");
            } else if (list.get(i).get("user_role").equals(2)) {
                list.get(i).put("user_role", "医保人员");
            }
        }
        PageInfo<Map<String, Object>> pageInfo = new PageInfo(list);
        return pageInfo;
    }

}
