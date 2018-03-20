<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息录入</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/jQuery/jquery2.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/bootstrap/js/bootstrap.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/lib/bootstrap/css/bootstrap.css" />
</head>
<body role="document">
	 <!-- Fixed navbar -->
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Bootstrap theme</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="#about">About</a></li>
            <li><a href="#contact">Contact</a></li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href="#">Action</a></li>
                <li><a href="#">Another action</a></li>
                <li><a href="#">Something else here</a></li>
                <li role="separator" class="divider"></li>
                <li class="dropdown-header">Nav header</li>
                <li><a href="#">Separated link</a></li>
                <li><a href="#">One more separated link</a></li>
              </ul>
            </li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>

    <div class="container theme-showcase" role="main">

      <!-- Main jumbotron for a primary marketing message or call to action -->
      <div class="jumbotron">
        <h1>用户信息</h1>
      	<fieldset>
      	<div class="form-group col-lg-12">
      		<label for="inputEmail3" class="col-sm-1 control-label">Email</label>
      		<div class="col-sm-11">
		      <input type="email" class="form-control" id="inputEmail3" placeholder="Email">
		    </div>
      	</div>
      	</fieldset>
      	<div class="input-group col-lg-12">
      		<span class="input-group-addon" id="basic-addon1">@</span>
      		<input type="text" class="form-control" placeholder="Recipient's username" aria-describedby="basic-addon2">
      	</div>
      	<fieldset>
	      	<div class="input-group col-lg-12">
	      		<span class="input-group-addon" id="basic-addon1">@</span>
	      		<input type="text" class="form-control" aria-label="Amount (to the nearest dollar)">
	      	</div>
      	</fieldset>
      </div>


      
    </div> <!-- /container -->

  </body>
</body>
</html>