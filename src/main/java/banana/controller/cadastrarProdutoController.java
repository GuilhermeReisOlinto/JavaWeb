 package banana.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import banana.model.Produto;

/**
 * Servlet implementation class cadastrarProdutoController
 */
public class cadastrarProdutoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cadastrarProdutoController() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("Recebi a requiseção get");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Faz conexção com os dados do fronte
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
	
		

		//Fazendo validação
		RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarProduto.jsp");
		dispatcher.forward(request, response);
		if(request.getParameter("descricao")!= null && !request.getParameter("descricao").isEmpty() && request.getParameter("quantidade")!= null && !request.getParameter("quantidade").isEmpty() &&
		   request.getParameter("preco")!= null && !request.getParameter("preco").isEmpty() &&	request.getParameter("onLine")!= null && request.getParameter("onLine").equals("on")) {
		
			String descricao;
			int quantidade;
			double preco;
			boolean onLine; 
			String mensagem;
			
			descricao = request.getParameter("descricao");
			quantidade =Integer.parseInt(request.getParameter("quantidade"));
		    preco = Double.parseDouble(request.getParameter("preco"));
			onLine = true;
			//Objeto da Classe CadastrarProduto 
		    Produto produto = new Produto(descricao, quantidade, preco, onLine);
            produto.salvar();	

			mensagem  = "Produto Cadastrado Com Sucesso!!";
			request.setAttribute("mensagem", mensagem);
		}else {
			String mensagem;
			mensagem = "Os Campos Precisam ser Preenchidos!"; 
			request.setAttribute("mensagem", mensagem);
		
		}
		
	}

}
