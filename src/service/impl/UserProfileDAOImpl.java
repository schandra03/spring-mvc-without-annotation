package service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import dao.UserProfileDAO;
import domain.UserProfile;

public class UserProfileDAOImpl implements UserProfileDAO {

	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void insertUser(UserProfile userprofile) {
		String query = "INSERT INTO FORUMS (FORUM_ID, FORUM_NAME, FORUM_DESC) VALUES (?,?,?)";
		jdbcTemplate.update(query, new Object[] { userprofile.getUserId(),
				userprofile.getPassword() });
	}

	public UserProfile selectUser(String userid) {
		String query = "SELECT * FROM USER_PROFILE WHERE USER_ID = ?";
		return (UserProfile) jdbcTemplate.queryForObject(query,
				new Object[] { userid }, new RowMapper() {
					public Object mapRow(ResultSet resultSet, int rowNum)
							throws SQLException {
						return new UserProfile(resultSet.getString("USER_ID"),
								resultSet.getString("PASSWORD"));
					}
				});
	}
}
