

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import projetPizza.Pizza;

/**
 * Servlet implementation class Ajouter
 */
@WebServlet("/Ajouter")
public class Ajouter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ajouter() {
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
		HttpSession session = request.getSession();
		Enumeration <String> names =   request.getParameterNames();
		List <Pizza> pizzas = new ArrayList<>();
		
		while (names.hasMoreElements()) {
			String name = names.nextElement();
			String value = request.getParameter(name);
			if (value!=null) {
				Pizza pizza = new Pizza();
				pizza.setNom(value);
				switch(value) {
				case "MARGHERITA":
					pizza.setPrix(10);
					break;
				case "SALMON":
					pizza.setPrix(12);
					break;
				case "NAPOLITAINE":
					pizza.setPrix(12);
					break;
				case "FORMAGGI":
					pizza.setPrix(12);
					break;
				
				case "BOLOGNAISE":
					pizza.setPrix(13);
					break;
				case "TONO":
					pizza.setPrix(12);
					break;	
				case "FRUTTI DI MARE":
					pizza.setPrix(12);
					break;	
				}
				pizzas.add(pizza);
			}
		}
	
		
		/*
		List <Pizza> pizzas2 = new ArrayList<>();
		pizzas2 = (List<Pizza>) session.getAttribute("pizzas");
		for(Pizza pizza:pizzas2) {
			out.print("name:");
			out.println(pizza.getNom());
			out.print("prix:");
			out.println(pizza.getPrix());
		}	
		*/	
		if(session.getAttribute("pizzas") != null) {
			pizzas.addAll((ArrayList<Pizza>)session.getAttribute("pizzas"));
		}
		session.setAttribute("pizzas", pizzas);
		
		
		response.sendRedirect("/projetPizza/menu.html");
		
	}

}
