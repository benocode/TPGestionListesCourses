<%@ page language="java"
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Nouvelle liste</title>
        
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
			<h2 class="text-center">Nouvelle liste</h2>
		</div>
		<hr class="row offset-2 col-8">
		<form action="${pageContext.request.contextPath}/NouvelleListe" method="post">
			<div class="row d-flex align-items-center">
				<div class="offset-2 col-2 text-end">
					<label>Nom :</label>
				</div>
				<div class="col-5">
					<input type="text" maxlength="120" class="form-control">
				</div>
			</div>

		<!-- Affichage de la liste -->
		<div class="row">
			<div class="offset-4 col-5">
				<ul class="list-group">
					<li class="list-group-item">${nomAttribut}
						<i class="fa-regular fa-circle-xmark fa-2x"></i>
					</li>
				</ul>
			</div>
		</div>
		
		
			<div class="row d-flex align-items-center">
				<div class="offset-2 col-2 text-end">
					<label>Article :</label>
				</div>
				<div class="col-5">
					<input type="text" maxlength="200" class="form-control">
				</div>
				<div class="col-2">
					<button type="submit" class="btn btn-link text-dark align-items-center">
						<i class="fa-solid fa-square-plus fa-2x"></i>
					</button>
				</div>
			</div>
		</form>
	</main>
	
	<footer class="container">
		<div class="row my-3">
			<div class="text-center offset-2 col-8 bg-dark">
				<a href="${pageContext.request.contextPath}/ListesCourses" class="btn btn-link text-light align-items-center">
					<i class="fa-solid fa-arrow-right fa-2x"></i>
				</a>
			</div>
		</div>
	</footer>
</body>
</html>