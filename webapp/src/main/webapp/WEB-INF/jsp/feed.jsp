<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<html>
<jsp:include page="head.jsp" />
<body>
<jsp:include page="navbar.jsp" />
<div class="container">
    <div class="row">
        <div class="col-md-2">
            <h2>${greeting}</h2>
        </div>
        <div class="col-md-3 col-md-offset-6">
            <form class="navbar-form navbar-left" role="search" action="/search">
    			<div class="form-group">
					<input type="text" name="searchText" class="form-control" id="searchText">
    			</div>
    			<button type="submit" class="btn btn-default">Search</button>
			</form>
        </div>
    </div>
    <img src="${imageLink}"></img>
</div>
</body>
</html>