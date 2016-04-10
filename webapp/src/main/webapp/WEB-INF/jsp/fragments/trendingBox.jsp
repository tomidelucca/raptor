<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="panel panel-raptor panel-trends">
    <h5>RAPTOR TRENDS</h5>
    <ul>
        <c:forEach items="${requestScope.trendsList}" var="trend">
            <li><a href="/search?searchText=%23${trend}">#${trend}</a></li>
        </c:forEach>
    </ul>
</div>