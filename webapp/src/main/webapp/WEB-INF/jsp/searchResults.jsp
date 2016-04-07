<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<html>
<jsp:include page="head.jsp" /></head>
<body>
<jsp:include page="navbar.jsp" />
<div class="container">
		<c:choose>
			<c:when test="${searchType=='tweetSearch'}">
			<div class="panel panel-raptor">
				<div class="panel-heading timeline-heading">
					<a class="active" href="#" style="width: 100%;">
					${number} result(s) found for <span style="text-transform: none;">"${searchText}"</span>
					</a>
				</div>
				<c:forEach items="${resultList}" var="tweet">
				<div class="panel panel-rawr">
					<div class="row">
						<div class="col-xs-4 col-sm-2 col-md-2">
							<img class="profile-picture center-block" src="/resources/img/default-pic.png"/>
						</div>
						<div class="col-xs-8 col-sm-10 col-md-10">
							<span>${tweet.owner.firstName} ${tweet.owner.lastName} <span style="color: #9B9B9B;">@${tweet.owner.username}</span></span>
							<span style="color: #9B9B9B" class="pull-right">${tweet.timestamp}</span><br/><br/>
							<span style="font-size:1.2em;">${tweet.msg}</span>
						</div>
					</div>
				</div>
				</c:forEach>
			</div>
			</c:when>
			<c:when test="${searchType=='userSearch'}">
				<h2>${number} result(s) found for "${searchText}"</h2>
				<div class="panel panel-default">
					<div class="row">
						<div class="col-md-7 col-md-offset-3" style="margin-top:20px;">
							<c:forEach items="${resultList}" var="user">
								<div class="panel panel-info">
									<div class="panel-heading">
										<a href="/user/${user.username}">
											<h3 class="panel-title">${user.firstName} ${user.lastName} - @${user.username}</h3>
										</a>
									</div>
									<div class="panel-body">
										<strong style="word-wrap:break-word;">User ID: ${user.id}</strong><br/><br/>E-mail: ${user.email}
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</c:when>
			<c:otherwise>
				<div class="section-not-found">
					<div class="container">
						<div class="col-centered col-md-8" style="text-align:center;">
							<div class="row">
								<h2 style="margin-bottom: 50px;">Ups! Search by hashtag isn't ready yet! Try again later.</h2>
								<img class="raptor-logo" src="/resources/img/raptor-angry.png"/>
							</div>
						</div>
					</div>
				</div>
			</c:otherwise>
		</c:choose>
</div>
</body>
</html>