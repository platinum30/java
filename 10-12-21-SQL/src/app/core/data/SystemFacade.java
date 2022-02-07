package app.core.data;

import java.sql.Connection;
import java.sql.SQLException;

public class SystemFacade {
	private BookDAO bookDAO = new BookDAO();
	private DataSource ds = DataSource.getInstance();

	private UserDAO userDao = new UserDAO();

	public int addBook(Book book) {
		Connection con = ds.getConnection();
		try {
			// start a transaction
			con.setAutoCommit(false);
			int id = bookDAO.create(con, book);
			con.commit();// end the transaction with commit - success
			return id;
		} catch (SQLException e) {
			try {
				if (con != null) {
					con.rollback();// end the transaction with rollback - fail
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new RuntimeException("add book failed", e);
		} finally {
			ds.returnConnection(con);
		}

	}

	public Book getBook(int bookId) {
		Connection con = DataSource.getInstance().getConnection();
		try {
			Book book = this.bookDAO.read(con, bookId);
			return book;
		} catch (Exception e) {
			throw e;
		} finally {
			DataSource.getInstance().returnConnection(con);
		}
	}

	public void transferMoney(int from, int to, double amount) {
		Connection con = DataSource.getInstance().getConnection();
		try {
			con.setAutoCommit(false);
			userDao.takeFrom(con, from, amount);
			userDao.giveTo(con, to, amount);
			con.commit();
			System.out.println("action commited");
		} catch (Exception e) {
			try {
				con.rollback();
				System.out.println("failed - ROLLBACK");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DataSource.getInstance().returnConnection(con);
		}
	}
}
