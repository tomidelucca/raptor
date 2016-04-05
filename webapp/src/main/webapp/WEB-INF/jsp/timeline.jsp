<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <c:choose>
        <c:when test="${userExists=='1'}">
	        <title>Hi, ${username}</title>
        </c:when>
        <c:otherwise>
            <title>:(</title>
        </c:otherwise>
    </c:choose>
    <script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
	<div class="col-md-6 col-centered">
        <div class="row">
            <c:choose>
                <c:when test="${userExists=='1'}">
                    <h2>Rawr!</h2>
                    <div class="col-md-5">
                        <img src="http://vignette4.wikia.nocookie.net/rickandmorty/images/b/be/Photography_Raptor.png/revision/latest?cb=20150821214726" style="height:200px;"/>
                        <p>Hi, ${username}</p>
                    </div>
                    <div class="col-md-7">
                        <div>
                            <label>User Id: </label>
                            <p>${userId}</p>
                        </div>
                        <div>
                            <label>Full name: </label>
                            <p>${firstName} ${lastName}</p>
                        </div>
                        <div>
                            <label>Username: </label>
                            <p>@${username}</p>
                        </div>
                        <div>
                            <label>Email: </label>
                            <p>${email}</p>
                        </div>
                    </div>
                </c:when>
                <c:otherwise>
                    <h2>Ups! The requested user doesn't exist!</h2>
                    <div class="col-md-4 col-md-offset-3">
                        <img src="http://i.imgur.com/icWJ1Qx.png" style="height:200px;"/>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
        <a href="/" class="btn btn-default">Go home!</a>
    </div>
    <c:if test="${userExists=='1'}">
    <div class="col-md-6">
        <h2>Say something!</h2>
        <form class="form-group" action="./${username}/tweetAction" method="post">
            <textarea placeholder="What's going on?" name="message" class="form-control"></textarea>
            <br/>
            <button type="submit" class="btn btn-success">Rawr</button>
        </form>
        <h2>${firstName}'s Timeline</h2>
        <c:forEach items="${tweetList}" var="tweet">
           <div class="panel panel-info">
               <div class="panel-heading">
                   <h3 class="panel-title">${firstName} ${lastName} - @${username}</h3>
               </div>
             <div class="panel-body">
               <strong>${tweet.getMsg()}</strong><br/><br/>${date}
             </div>
           </div>
        </c:forEach>
    </div>
    </c:if>
</div>
</body>
</html>