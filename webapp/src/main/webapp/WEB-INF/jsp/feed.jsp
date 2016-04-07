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
    </div>
    <img src="${imageLink}"></img>
</div>
</body>
</html>