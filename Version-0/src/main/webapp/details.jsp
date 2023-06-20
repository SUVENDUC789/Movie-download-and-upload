<%@page import="java.sql.ResultSet"%>
<%@page import="com.db.manager.MyConnection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%!String mname, language, quality, Genres, country, Actors, gdrive, mpic;%>


<%
String id = request.getParameter("id");
String sql = "SELECT * FROM movie_details_list WHERE mid = '" + id + "'";
MyConnection dao = new MyConnection();
ResultSet rs = dao.fetchData(sql);

while (rs.next()) {
	int mid = rs.getInt("mid");
	mname = rs.getString("movie_name");
	language = rs.getString("language");
	quality = rs.getString("Quality");
	Genres = rs.getString("Genres");
	country = rs.getString("country");
	Actors = rs.getString("Actors");
	gdrive = rs.getString("gdrive");
	mpic = rs.getString("image");
}
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon"
	href="data:image/jpeg;base64,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"
	type="image/x-icon">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<style>
.jamboard-container {
	background-color: #f2f2f2;
	padding: 40px;
	text-align: center;
}

.jamboard-item {
	display: flex;
	align-items: center;
	justify-content: flex-start;
	border: 1px solid #ccc;
	padding: 20px;
	margin-bottom: 20px;
}

.jamboard-item img {
	max-width: 100%;
	margin-right: 20px;
}





   .card {
      display: flex;
      align-items: center;
    }
    .card-body {
      flex: 1;
      background-color: #f8f9fa; /* Light background color */
    }
    .profile-pic {
      background-color: #343a40; /* Dark background color */
      width: 50px;
      height: 50px;
    }
</style>
<title>Details - <%=mname%></title>
</head>
<body>
	<%@include file="header.jsp" %>
	
	<div class="container my-3">
		<div class="row justify-content-center">
			<div class="col-md-6">
				<div class="jamboard-container">
					<div class="jamboard-item">
						<img src="<%=mpic%>" alt="Image 1" width="200" height="333">
						<div>
							<h3><%=mname %> Full Movie Download</h3>
							<p><b>Language: </b><i style="color:red;"><%=language %></i></p>
							<p><b>Quality: </b><%=quality %></p>
							<p><b>Genres: </b><%=Genres %></p>
							<p><b>Country: </b><%=country %></p>
							<p><b>Actors: </b><%=Actors %></p>
							<p><a href="<%= gdrive%>"><img alt="s" src="static/Download.gif"></a></p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	
	
	  <div class="container my-2">
	  <h3 class="text-center">1,026 COMMENTS
	  </h3>
    <div class="row">
      <div class="col-md-6 offset-md-3">
        <div class="card mt-5">
          <div class="card-body">
            <div class="media">
              <div class="profile-pic mr-3 rounded-circle"></div>
              <div class="media-body">
                <h5 class="card-title">John Doe</h5>
                <p class="card-text">Thank you for your feedback!</p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
	<%@include file="footer.html" %>
</body>
</html>
