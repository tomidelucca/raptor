<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Feed</title>
    <script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-2">
            <h2>${greeting}</h2>
        </div>
        <div class="col-md-3 col-md-offset-6">
            <a href="/signup" class="btn btn-default" style="margin-top:20px;">Sign Up!</a>
            <form class="navbar-form navbar-left" role="search" action="/search">
    			<div class="form-group">
					<input type="text" name="searchText" class="form-control" id="searchText">
    			</div>
    			<button type="submit" class="btn btn-default">Search</button>
			</form>
        </div>
    </div>
    <img src="${imageLink}"></img>
</div>
</body>
</html>