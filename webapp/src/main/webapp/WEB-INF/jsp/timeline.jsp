<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<html>
<c:choose>
    <c:when test="${user != null}">
        <c:set var="pageTitle" value="Hi, ${user.username}" scope="request"/>
    </c:when>
    <c:otherwise>
        <c:set var="pageTitle" value=":(" scope="request"/>
    </c:otherwise>
</c:choose>
<jsp:include page="fragments/head.jsp"/>
<body>
<jsp:include page="fragments/navbar.jsp" />
<div class="section-body">
    <div class="container">
        <c:choose>
        <c:when test="${user != null}">
            <div class="section-profile">
                <div class="col-md-3">
                    <div class="row">
                        <c:set var="user" value="${user}" scope="request"/>
                        <jsp:include page="fragments/profileBox.jsp"/>
                    </div>
                </div>
            </div>
            <div class="section-timeline">
                <div class="col-md-9">
                    <c:set var="username" value="${user.username}" scope="request"/>
                    <jsp:include page="fragments/tweetBox.jsp"/>
                    <c:set var="tweetList" value="${tweetList}" scope="request"/>
                    <c:set var="tweetListTitle" value="Timeline" scope="request"/>
                    <jsp:include page="fragments/tweetList.jsp"/>
                </div>
            </div>
        </c:when>
            <c:otherwise>
                <c:set var="errorMessage" value="Ups! The requested user doesn't exist!" scope="request"/>
                <jsp:include page="fragments/errorPage.jsp"/>
            </c:otherwise>
        </c:choose>
    </div>
</div>
</body>
</html>