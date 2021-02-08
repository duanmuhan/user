package com.cgs.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface UserAuthorityRoleMappingDAO {

    String TABLE_NAME = " user_authority ";

    String COLUMNS = " role_id, role_name, block_id, block_name";
}
