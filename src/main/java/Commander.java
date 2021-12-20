

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
import projetPizza.Pizza;

/**
 * Servlet implementation class Commander
 */
@WebServlet("/Commander")
public class Commander extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Commander() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		javax.servlet.ServletContext application = getServletContext();
		HttpSession session = request.getSession();
		Commande com =new Commande();
		com.setNom(request.getParameter("nom"));
		com.setAdresse(request.getParameter("adresse"));
		com.setPrenom(request.getParameter("prenom"));
		com.setListPizza((ArrayList<Pizza>)session.getAttribute("pizzas"));
		com.setPrixTotal();
		ArrayList<Commande> listCommande;
		if(application.getAttribute("commandes") == null) {
			listCommande = new ArrayList<Commande>();
		}
		else {
			listCommande = (ArrayList<Commande>) application.getAttribute("commandes");
			
		}
		listCommande.add(com);
		application.setAttribute("commandes", listCommande);
		out.println("Votre commande a été traité avec succès");
		
	}
	

}
