<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<html>
<jsp:include page="head.jsp" />
<body>
<jsp:include page="navbar.jsp" />
<div class="container">
    <div class="col-md-6 col-centered">
        <h2>Signup</h2>
        <form role="form" action="/registerUser" method="post">
            <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <label for="firstname">First name:</label>
                        <input type="text" name="firstName" class="form-control" id="firstName">
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <label for="lastname">Last name:</label>
                        <input type="text" name="lastName" class="form-control" id="lastName">
                    </div>
                </div>
            </div>
            <label for="username">Username:</label>
            <div class="form-group input-group">
                <span class="input-group-addon" id="usern">@</span>
                <input type="text" name="username" class="form-control" placeholder="Username" aria-describedby="usern" id="username">
            </div>
            <div class="form-group">
                <label for="email">Email address:</label>
                <input type="text" name="email" class="form-control" id="email">
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" name="password" class="form-control" id="password">
            </div>
            <button type="submit" class="btn btn-default">Sign up</button>
        </form>
    </div>
</div>
</body>
</html>
