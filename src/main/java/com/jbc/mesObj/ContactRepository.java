package com.jbc.mesObj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.JdbcAccessor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.jbc.beans.Contact;
import com.jbc.beans.ImmutableContact;

@Component
public class ContactRepository {
	
	private final String REQ1 = "select * from transfusionFile.contacts where id = ?"; 
	private final String REQ2 = "select * from transfusionFile.contacts where id = ? and emailAddress = ? "; 

	final static Logger log = LoggerFactory.getLogger(ContactRepository.class);
	@Autowired
	private JdbcOperations jdbc;

//	@Autowired
//	public ContactRepository(JdbcOperations jdbcOperations) {
//		this.jdbc = jdbc;
//	}

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
				});
	}

	public ImmutableContact findById1(long id) {
		return jdbc.queryForObject(REQ1 , new ContactMapper() , id );
	}
	public ImmutableContact findById2(long id, String email) {
		return jdbc.queryForObject(REQ2 , new ContactMapper() , id, email );
	}
	
	private static final class ContactMapper implements RowMapper<ImmutableContact> {
		@Override
		public ImmutableContact mapRow(ResultSet rs, int rowNum) throws SQLException {
			return ImmutableContact.builder().id(rs.getLong(1))
			.firstName(rs.getString(2)).lastName(rs.getString(3))
			.phoneNumber(rs.getString(4)).emailAddress(rs.getString(5)).build();
			
		}
	}
	
	
	public Contact findById(long id) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ((JdbcTemplate) jdbc).getDataSource().getConnection();
			stmt = con.prepareStatement(REQ1);
//			stmt = con.createStatement();
			stmt.setLong(1, id);
			rs = stmt.executeQuery();
			int nbElement = rs.getStatement().getFetchSize();
			log.debug("nbElement => " + nbElement);
			return fillContact(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	private ImmutableContact fillContact(ResultSet rs) throws SQLException {
		while(rs.next()) {
			ImmutableContact.Builder b1 = ImmutableContact.builder();
			b1.id(rs.getLong(1));
			b1.firstName(rs.getString(2));
			b1.lastName(rs.getString(3));
			b1.phoneNumber(rs.getString(4));
			b1.emailAddress(rs.getString(5));
			ImmutableContact c1 = b1.build();
			return c1;
		}
		return null;
	}

}


