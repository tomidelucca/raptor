<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<html>
<c:set var="pageTitle" value="Feed" scope="request"/>
<jsp:include page="fragments/head.jsp"/>
<body>
<jsp:include page="fragments/navbar.jsp" />
<div class="container">
    <div class="section-timeline">
        <div class="col-md-8 col-md-offset-2">
            <c:set var="tweetList" value="${tweetList}" scope="request"/>
            <c:set var="tweetListTitle" value="Global feed" scope="request"/>
            <jsp:include page="fragments/tweetList.jsp"/>
        </div>
    </div>
    <div class="section-trends">
        <div class="col-md-2" style="padding-left:0px;">
            <c:set var="trendsList" value="${trendsList}" scope="request"/>
            <jsp:include page="fragments/trendingBox.jsp"/>
        </div>
    </div>
</div>
</body>
</html>