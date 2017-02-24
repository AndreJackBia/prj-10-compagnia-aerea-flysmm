package frontController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import org.hibernate.Query;
import org.hibernate.Session;

import booking.Baggage;
import booking.Book;
import booking.Passenger;
import sale.Flight;
import servlets.SessionFactorySingleton;

public class DeleteBookCommand extends FrontCommand {

	@Override
	public void dispatch() throws ServletException, IOException {
		this.deleteBook((String) request.getAttribute("deleteBookId"));
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/homeCustomer.jsp");
		requestDispatcher.forward(request, response);
	}

	public static void deleteBook(String bookId) {
		Session session = SessionFactorySingleton.getSessionFactory().getCurrentSession();
		session.getTransaction().begin();
		Query q = session.createQuery("delete from Book where IdBook = '" + bookId + "'");
		q.executeUpdate();
		session.getTransaction().commit();
	}

}
