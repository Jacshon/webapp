package com.github.webapp.backend.demo.service;

import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * @author wangweijiang
 * @since 2019-09-27 14:56
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void queryDB() {
        String username = "18810943578@sohu.com";
        String searchUser = "select id from auth_user where username = ?";
        Integer userId = jdbcTemplate.queryForObject(searchUser, Integer.class, username);
        System.out.println(userId);
        String deleteSession = "delete from account_session where user_id = ?";
        int update = jdbcTemplate.update(deleteSession, userId);
        System.out.println(update);
        String deleteCell = "delete from account_userinfo where user_id = ?";
        jdbcTemplate.update(deleteCell, userId);
        String deleteBackUpMate = "delete from backup_backupmeta where user_id = ?";
        jdbcTemplate.update(deleteBackUpMate, userId);
        String deletePermission = "delete from auth_user_user_permissions where user_id = ?";
        jdbcTemplate.update(deletePermission, userId);
        String deleteLog = "delete from django_admin_log where user_id = ?";
        jdbcTemplate.update(deleteLog, userId);
        String updateOrder = "update order_order set user_id = 1 where user_id = ?";
        jdbcTemplate.update(updateOrder, userId);

    }
}
