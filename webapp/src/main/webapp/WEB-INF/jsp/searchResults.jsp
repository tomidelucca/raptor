<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Results for ${searchText}</title>
    <script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
	<div class="col-md-4 col-centered">
        <div class="row">
        	<c:choose>
	        	<c:when test="${searchType=='tweetSearch'}">
	        		<h2><a href="/">RAPTOR</a></h2>
        			<h2>${number} results found for "${searchText}"</h2>
	            	<div class="panel panel-default">
	                    <div class="row">
	                        <div class="col-md-7 col-md-offset-3" style="margin-top:20px;">
				            	<c:forEach items="${resultList}" var="tweet">
				           			<div class="panel panel-info">
					               		<div class="panel-heading">
					                   		<h3 class="panel-title">NOMBRE APELLIDO - @username</h3>
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
        			<h2>${number} results found for "${searchText}"</h2>
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