package com.tseidler.domain;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ActorMaper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Integer id = rs.getInt("id");
        String firstName = rs.getString("firstname");
        String lastName = rs.getString("lastname");
        Actor actor = new Actor(firstName, lastName);
        actor.setId(id);
        return actor;
    }
}
