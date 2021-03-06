<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<html>
<c:set var="pageTitle" value="Search Results" scope="request"/>
<jsp:include page="fragments/head.jsp"/>
<body>
<jsp:include page="fragments/navbar.jsp" />
<div class="container">
		<c:choose>
			<c:when test="${searchType=='tweetSearch'}">
				<c:set var="tweetList" value="${resultList}" scope="request"/>
				<c:set var="tweetListTitle" value="${number} result(s) found for ${searchText}" scope="request"/>
				<jsp:include page="fragments/tweetList.jsp"/>
			</c:when>
			<c:when test="${searchType=='userSearch'}">
				<h2>${number} result(s) found for "${searchText}"</h2>
				<div class="row">
					<c:forEach items="${resultList}" var="user">
						<c:set var="user" value="${user}" scope="request"/>
						<div class="col-md-3">
							<jsp:include page="fragments/profileBox.jsp"/>
						</div>
					</c:forEach>
				</div>
			</c:when>
			<c:otherwise>
				<c:set var="errorMessage" value="Ups! Something went wrong when searching." scope="request"/>
				<jsp:include page="fragments/errorPage.jsp"/>
			</c:otherwise>
		</c:choose>
</div>
</body>
</html>