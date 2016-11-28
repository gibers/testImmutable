package com.jbc.mesObj;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.jbc.beans.Contact;
import com.jbc.beans.ImmutableContact;

@Repository
public class ContactRepository {

	private JdbcTemplate jdbc;

	@Autowired
	public ContactRepository(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	public List<Contact> findAll() {
		return jdbc.query(
				"select id, firstName, lastName, phoneNumber, emailAddress " +
						"from contacts order by lastName",
						new RowMapper<Contact>() {
					public ImmutableContact mapRow(ResultSet rs, int rowNum) throws SQLException {
						ImmutableContact.Builder builder = ImmutableContact.builder();
						builder.id(rs.getLong(1)).firstName(rs.getString(2)).lastName(rs.getString(3))
						.phoneNumber(rs.getString(4)).emailAddress(rs.getString(5));
						ImmutableContact contact = builder.build();
						return contact;
					}
				}
				);
	}


}
