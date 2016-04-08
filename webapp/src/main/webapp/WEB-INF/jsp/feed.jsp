<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<html>
<c:set var="pageTitle" value="Feed" scope="request"/>
<jsp:include page="fragments/head.jsp"/>
<body>
<jsp:include page="fragments/navbar.jsp" />
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