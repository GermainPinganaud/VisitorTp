<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Get</h1>
<script type="text/javascript" src="http://www.visitorjs.com/visitor.js?key=YOUR_KEY"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
let v_ip = ''
let v_country = ''
let v_os = ''
let v_version = ''
let v_ = ''
$.ajax({
 url: 'http://localhost/get/',
 type: 'GET',
 data: v_ip
}).done(function(response) {
  listes = showLists(response.todoListes);
});
</script>
</body>
</html>
