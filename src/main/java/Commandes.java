

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import projetPizza.Commande;

/**
 * Servlet implementation class Commandes
 */
@WebServlet("/Commandes")
public class Commandes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Commandes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		javax.servlet.ServletContext application = getServletContext();
		HttpSession session = request.getSession();
		ArrayList<Commande> listCommande;
		out.println("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"UTF-8\">\r\n"
				+ "<title>Insert title here</title>\r\n"
				+ "</head>\r\n"
				+ "<style>\r\n"
				+ "   table, th, td {\r\n"
				+ "     border:1px solid black;\r\n"
				+ "   }\r\n"
				+ "   \r\n"
				+ "</style>\r\n"
				+ "<body>");
		
		
		
		
		out.println("    <table>\r\n"
				+ "        <tr>\r\n"
				+ "          <th>Nom</th>\r\n"
				+ "          <th>Prenom</th>\r\n"
				+ "          <th>Adresse</th>\r\n"
				+ "          <th>Prix total</th>\r\n"
				+ "        </tr>");
		listCommande = (ArrayList<Commande>) application.getAttribute("commandes");
		for(Commande comm:listCommande) {
			out.println("<tr>");
			out.println("<td>"+comm.getNom()+"</td>");
			out.println("<td>"+comm.getPrenom()+"</td>");
			out.println("<td>"+comm.getAdresse()+"</td>");
			out.println("<td>"+"<a href = \"http://localhost:8080/projetPizza/AfficheCommande.jsp?id="+listCommande.indexOf(comm)+"\" >"+comm.getPrixTotal()+"</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</body>\r\n"
				+ "\r\n"
				+ "</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
