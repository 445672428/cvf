<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

<head>

<title>down</title>

<script type="text/javascript">

var currProgress = 0;

var done = false;

var total = 100;

 

function startProgress() {

var prBar =document.getElementById("prog");

var startButt =document.getElementById("startBtn");

var val =document.getElementById("numValue");

startButt.disabled=true;

prBar.value = currProgress;

val.innerHTML =Math.round((currProgress/total)*100)+"%";

 

currProgress++;

if(currProgress>100) done=true;

if(!done)

   setTimeout("startProgress()", 100);

else    

{

   document.getElementById("startBtn").disabled = false;

   done = false;

   currProgress = 0;

}

}

</script>

</head>

<body>

 

 

 

<p>Task progress:</p>

<progress id="prog"value="0" max="100"></progress> 

<input id="startBtn"type="button" value="start" onclick="startProgress()"/>

<divid="numValue">0%</div>

 

</body>

</html>