
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<div class="container-fluid">
		<a class="navbar-brand" href="home">123suv</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="home">Home</a></li>

				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="upload">Upload</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-bs-toggle="dropdown" aria-expanded="false">
						Movie Category </a>
					<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
						<li><a class="dropdown-item" href="#">Hindi Movie </a></li>
						<li>
							<hr class="dropdown-divider">
						</li>
						<li><a class="dropdown-item" href="#">English Movie</a></li>
						<li>
							<hr class="dropdown-divider">
						</li>
						<li><a class="dropdown-item" href="#">South Movie</a></li>
					</ul></li>

			</ul>

			<!-- THIS PLACE ONLU USE SESSION TIME  -->
			<div class="d-flex">

				<%
				String uname2 = (String) session.getAttribute("username");
				if (uname2 != null) {
					//response.sendRedirect("index.jsp");
					//out.println("<a class=' active btn btn-danger ' aria-current='page' href='#'>" + uname2 + "</a>");
					out.println("<a class=' active btn btn-success mx-2' aria-current='page' href='Logout'>log-out</a>");
					out.println("<a class=' active btn btn-danger ' aria-current='page' href='control-panel'>" + uname2 + " panel</a>");
				}
				%>

				<!-- Greet welcome user  -->
			</div>
			<!-- THIS PLACE ONLU USE SESSION TIME  -->

		</div>
	</div>
</nav>