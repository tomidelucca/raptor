<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<html>
<jsp:include page="head.jsp" /></head>
<body>
<jsp:include page="navbar.jsp" />
<div class="container">
	<div class="col-md-4 col-centered">
        <div class="row">
        	<c:choose>
	        	<c:when test="${searchType=='tweetSearch'}">
	        		<h2><a href="/">RAPTOR</a></h2>
        			<h2>${number} result(s) found for "${searchText}"</h2>
	            	<div class="panel panel-default">
	                    <div class="row">
	                        <div class="col-md-7 col-md-offset-3" style="margin-top:20px;">
				            	<c:forEach items="${resultList}" var="tweet">
				           			<div class="panel panel-info">
					               		<div class="panel-heading">
					                   		<h3 class="panel-title">${tweet.owner.firstName} ${tweet.owner.lastName} - @${tweet.owner.username}</h3>
					               		</div>
					             		<div class="panel-body">
					               			<strong style="word-wrap:break-word;">${tweet.msg}</strong><br/><br/>${tweet.timestamp}
					             		</div>
				           			</div>
				        		</c:forEach>
                			</div>
                        </div>
                    </div>
                </c:when>
	        	<c:when test="${searchType=='userSearch'}">
	        		<h2><a href="/">RAPTOR</a></h2>
        			<h2>${number} result(s) found for "${searchText}"</h2>
	            	<div class="panel panel-default">
	                    <div class="row">
	                        <div class="col-md-7 col-md-offset-3" style="margin-top:20px;">
				            	<c:forEach items="${resultList}" var="user">
				           			<div class="panel panel-info">
					               		<div class="panel-heading">
					                   		<h3 class="panel-title">${user.firstName} ${user.lastName} - @${user.username}</h3>
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
                    <h2>Ups! Search by hashtag isn't ready yet! Try again later.</h2>
                    <div class="col-md-4 col-md-offset-3">
                        <img src="http://i.imgur.com/icWJ1Qx.png" style="height:200px;"/>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>
</body>
</html>