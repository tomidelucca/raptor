<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- Params needed: tweetList: List, tweetListTitle: String || header: List<Map<String, Object>> --%>
<div class="panel panel-raptor">
    <div class="panel-heading timeline-heading">
        <c:choose>
            <c:when test="${requestScope.header == null}">
                <a class="active" href="#">${requestScope.tweetListTitle}</a>
            </c:when>
            <c:otherwise>
                <c:forEach items="${requestScope.header}" var="item">
                    <a <c:if test="${item['active']}">class="active"</c:if> href="${item['link']}">
                            ${item['title']}</a>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </div>
    <c:choose>
        <c:when test="${empty requestScope.tweetList}">
            <div class="panel panel-rawr" style="padding-top: 15px;">
                <div class="row">
                    <div class="col-xs-8 col-sm-10 col-md-10">
                        <span>Oops! No tweets.</span>
                    </div>
                </div>
            </div>
        </c:when>
        <c:otherwise>
            <c:forEach items="${requestScope.tweetList}" var="tweet">
                <div class="panel panel-rawr">
                    <div class="row">
                        <div class="col-xs-4 col-sm-2 col-md-2">
                            <img class="profile-picture center-block" src="/resources/img/default-pic.png"/>
                        </div>
                        <div class="col-xs-8 col-sm-10 col-md-10">
                            <a href="/user/${tweet.owner.username}">${tweet.owner.firstName} ${tweet.owner.lastName}</></a>
                            <a href="/user/${tweet.owner.username}" style="color: #9B9B9B;">@${tweet.owner.username}</a>
                            <span style="color: #9B9B9B" class="pull-right">${tweet.timestamp}</span><br/><br/>
                            <span style="font-size:1.2em;">${tweet.msg}</span>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </c:otherwise>
    </c:choose>

</div>