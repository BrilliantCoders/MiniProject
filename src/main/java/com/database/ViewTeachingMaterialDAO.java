package com.database;

import com.model.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ViewTeachingMaterialDAO {
    @Autowired
    JdbcTemplate template;


}
