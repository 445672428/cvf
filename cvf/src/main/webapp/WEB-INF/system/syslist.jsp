<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script data-main="resources/js/login" type="text/javascript" src="${CONTEXTPATH }/resources/lib/vue/vue.min.js" charset="utf-8"></script>
<title>vue</title>
</head>
<body>
<div id="app">
  <p>{{ message }}</p>
</div>
</body>
<script type="text/javascript">
new Vue({
	  el: '#app',
	  data: {
	    message: 'Hello Vue.js!'
	  }
	})
</script>
</html>