<%@ page language="java"
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Vos listes</title>
        
    <!-- Font Awesome -->
	<script src="https://kit.fontawesome.com/3b0fdc01aa.js" crossorigin="anonymous"></script>    
	
	<!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
    	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>

<body>

	<%@ include file="header.html" %>
		
	<main class="container">
		<div class="row my-3">
			<h2 class="text-center">Listes</h2>
		</div>
		<hr class="row offset-2 col-8">
	
		<!-- Affichage des listes -->
		
		<a href="${pageContext.request.contextPath}/VotrePanier" class="btn btn-link text-dark">
			<i class="fa-solid fa-square-minus fa-2x"></i>
		</a>
		
	</main>
	
	<footer class="container">
		<div class="row my-3">
			<div class="text-center offset-2 col-8 bg-dark">
				<a href="${pageContext.request.contextPath}/NouvelleListe" class="btn btn-link text-light align-items-center">
					<i class="fa-solid fa-square-plus fa-2x"></i>
				</a>
			</div>
		</div>
	</footer>
</body>
</html>