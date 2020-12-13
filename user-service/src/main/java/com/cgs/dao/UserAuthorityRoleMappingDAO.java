package com.cgs.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface UserAuthorityRoleMappingDAO {

    String TABLE_NAME = " user_authority ";

    String COLUMNS = " system_id, system_name role_id, role_name, block_id, block_name";
}
