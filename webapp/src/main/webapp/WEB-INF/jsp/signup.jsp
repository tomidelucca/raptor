<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<html>
<jsp:include page="fragments/head.jsp" />
<body>
<jsp:include page="fragments/navbar.jsp" />
<div class="container">
    <div class="col-md-6 col-centered">
        <h2>Create your Raptor account</h2>
        <br/>
        <form role="form" action="/registerUser" method="post">
            <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <label for="firstName">First name:</label>
                        <input type="text" name="firstName" placeholder="First name" class="form-control" id="firstName">
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <label for="lastName">Last name:</label>
                        <input type="text" name="lastName" placeholder="Last name" class="form-control" id="lastName">
                    </div>
                </div>
            </div>
            <label for="username">Username:</label>
            <div class="form-group input-group">
                <strong class="input-group-addon" style="border-bottom-left-radius: 20px; border-top-left-radius: 20px;" id="usern">@</strong>
                <input type="text" name="username" class="form-control" placeholder="Username" aria-describedby="usern" id="username">
            </div>
            <div class="form-group">
                <label for="email">Email address:</label>
                <input type="text" name="email" placeholder="Email" class="form-control" id="email">
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" name="password" placeholder="Password" class="form-control" id="password">
            </div>
            <div class="checkbox">
                <label><input type="checkbox"> I accept the terms and conditions</label>
            </div>
            <button type="submit" class="btn btn-raptor pull-right">Sign up</button>
        </form>
    </div>
</div>
</body>
</html>
