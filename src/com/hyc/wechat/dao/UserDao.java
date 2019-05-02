/*
 * Copyright (c) 2019.  黄钰朝
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hyc.wechat.dao;

import com.hyc.wechat.dao.annotation.Query;
import com.hyc.wechat.dao.annotation.Result;
import com.hyc.wechat.dao.annotation.ResultType;
import com.hyc.wechat.dao.annotation.Table;
import com.hyc.wechat.model.po.User;

import java.util.List;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program wechat
 * @description 负责User类CRUD
 * @date 2019-05-01 23:39
 */
public interface UserDao extends BaseDao {
    String TABLE = "user";
    String ALL_FILED = "id,email,wechat_id,phone,password,gender,signature,name,profile_photo"
            + ",chat_background,location,online_status,status,gmt_create,gmt_modified";


    /**
     * 通过id查询一个用户
     *
     * @param id
     * @return 用户对象
     * @name getUserById
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/5/2
     */
    @Result(entity = User.class, returns = ResultType.OBJECT)
    @Query(value = "select " + ALL_FILED + " from " + TABLE + " where id = ? ")
    User getUserById(Object id);


    @Result(entity = User.class,returns = ResultType.LIST)
    @Query(value = "select "+ALL_FILED+" from "+ TABLE+" where name = ?")
    List<User> listByName(String name);
}