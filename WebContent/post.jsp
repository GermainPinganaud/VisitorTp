<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Post</h1>
<script type="text/javascript" src="http://www.visitorjs.com/visitor.js?key=YOUR_KEY"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
$.ajax({
 url: 'http://localhost/post/',
 type: 'POST',
 data: visitor
}).done(function(response) {
  listes = showLists(response.todoListes);
});
</script>
</body>
</html>
