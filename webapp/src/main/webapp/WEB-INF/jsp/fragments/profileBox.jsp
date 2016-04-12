<%-- Params needed: user: User--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="panel panel-raptor panel-profile">
    <ul>
        <li>
            <img class="profile-picture" src="/resources/img/default-pic.png"/>
        </li>
        <li style="font-size: 1.2em;"><a href="../user/${requestScope.user.username}">${requestScope.user.firstName} ${requestScope.user.lastName}</a></li>
        <li><a href="../user/${requestScope.user.username}">@${requestScope.user.username}</a></li>
    </ul>
</div>

