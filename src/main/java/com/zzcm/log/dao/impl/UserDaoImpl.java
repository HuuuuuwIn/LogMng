package com.zzcm.log.dao.impl;

import com.zzcm.log.bean.User;
import com.zzcm.log.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User,String> implements UserDao{

}
