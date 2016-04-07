
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<html>
<jsp:include page="head.jsp" />
<body>
<jsp:include page="navbar.jsp" />
<div class="section-body">
    <div class="container">
        <c:choose>
        <c:when test="${userExists=='1'}">
            <div class="section-profile">
                <div class="col-md-3">
                    <div class="row">
                        <div class="panel panel-raptor panel-profile">
                            <ul>
                                <li>
                                    <img class="profile-picture" src="/resources/img/default-pic.png"/>
                                </li>
                                <li style="font-size: 1.2em;">${firstName} ${lastName}</li>
                                <li>@${username}</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <div class="section-timeline">
                <div class="col-md-9">
                    <div class="panel panel-raptor">
                        <div class="section-posting">
                            <form class="form-group" action="./${username}/tweetAction" method="post">
                                <textarea placeholder="What's going on?" name="message" class="form-control" style="margin-bottom:10px;"></textarea>
                                <button type="submit" class="btn btn-raptor pull-right">Rawr</button>
                                <br/>
                            </form>
                        </div>
                    </div>
                    <div class="panel panel-raptor">
                        <div class="panel-heading timeline-heading">
                            <a class="active" href="#">Timeline</a>
                            <!--<a>Mentions</a>
                            <a>Likes</a>-->
                        </div>
                        <c:forEach items="${tweetList}" var="tweet">
                        <div class="panel panel-rawr">
                            <div class="row">
                                <div class="col-xs-4 col-sm-2 col-md-2">
                                    <img class="profile-picture center-block" src="/resources/img/default-pic.png"/>
                                </div>
                                <div class="col-xs-8 col-sm-10 col-md-10">
                                    <span>${firstName} ${lastName} <span style="color: #9B9B9B;">@${username}</span></span>
                                    <span style="color: #9B9B9B" class="pull-right">${tweet.timestamp}</span><br/><br/>
                                    <span style="font-size:1.2em;">${tweet.msg}</span>
                                </div>
                            </div>
                        </div>
                        </c:forEach>
                    </div>
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
</div>
</body>
</html>