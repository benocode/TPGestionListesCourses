<%@ page language="java"
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Votre panier</title>
        
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
			<h2 class="text-center">Votre panier</h2><br>
			<h3 class="text-center">(nom de la liste)</h3>
		</div>
		<hr class="row offset-2 col-8">
	
		<!-- Affichage des articles -->
		
	</main>
	
	<footer class="container">
		<div class="row my-3">
			<div class="d-flex justify-content-between offset-2 col-8 bg-dark">
				<div>
					<a href="${pageContext.request.contextPath}/ListesCourses" class="btn btn-link text-light">
						<i class="fa-solid fa-arrow-left fa-2x"></i>
					</a>
				</div>
				<div>
					<a href="#" class="btn btn-link text-light">
						<i class="fa-solid fa-eraser fa-2x"></i>
					</a>
				</div>
			</div>
		</div>
	</footer>
</body>
</html>