

<%@ page import="banana.model.Produto" %>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/bananaStyle.css">

<meta charset="ISO-8859-1">
<title>Banana Bacana</title>
</head>
<body>
	<nav class="bananaNav">
		<ul>
			<li><span style="color: yellow">BananaBacana</span></li>
			<li><img src="img/bacana.png" height="20px"></li>
			<li><a href="cadastrarProduto.jsp">Cadastrar Produto</a></li>
			<li><a href="consultarProduto.jsp">Consultar Produto</a></li>
		</ul>
	</nav>
	<main class="bananaMain">
		<form action="cadastrarProduto" method="post" class="bananaForm">
			<div>
				<label><strong>Busca pela Descrição:</strong></label><input type="text"
					name="descricao">
			</div>
			<br>
			<div>
				<input id="bananaButton" type="submit" name="salvar"
					value="Consultar Produto">
			</div>
			<%
				//estanciar produto e atribui
				if(request.getAttribute("produtos")!= null){
					List<?> produtos = (List<?>)request.getAttribute("produtos");
					for(int contador = 0; contador <=(produtos.size()-1); contador++){
						Produto produto = (Produto) produtos.get(contador);
			%>
		
			<div class="bananaDivMother">
				<div class="bananaDivItem">
					<div class="bananaColuna">
						<span style="form-weight:bold">Id</span>
						<span><%out.print(produto.getIdProduto()); %></span>
					</div>
					<div class="bananaColuna">
						<span style="form-weight:bold">Descrição</span>
						<span><%out.print(produto.getDescricao()); %></span>
					</div>
					<div class="bananaColuna">
						<span style="form-weight:bold">Quantidade</span>
						<span><%out.print(produto.getQuantidade()); %></span>
					</div>
					<div class="bananaColuna">
						<span style="form-weight:bold">Preço</span>
						<span><%out.print(produto.getPreco()); %></span>
					</div>
					<div class="bananaColuna">
						<span style="form-weight:bold">On-Line</span>
						<span><%out.print(produto.isOnLine()); %></span>
					</div>
					<div class="bananaColuna">
						<input class="bananaItemButton" type="submit" name="alterar"
						value="Alterar"><input class="bananaItemButton" type="submit" name="apagar"
						value="Apagar">
					</div>
				</div>
			</div>
			<%
					}			
				}
			%>
	 	</form>	
	</main>
</body>
</html>