<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>全国</title>
<script type="text/javascript" src="${CONTEXTPATH }/resources/lib/easyui/jquery.min.js" charset="utf-8"></script>  
</head>
<body>
<button onclick="upload()">aaaaaa</button>
<select name="s_province" id="s_province" style="width: 200px;"></select>
<select name="s_city" id="s_city" style="width: 200px;"></select>
<select name="s_county" id="s_county" style="width: 200px;"></select>
<div class="control-group" id="progressbar" style="display:none;">  
  <div class="progress progress-striped active">  
    <div class="bar" id="progressbardata" style="width: 0;"></div>  
  </div>  
</div>

<script type="text/javascript">
function upload() {  
    $('#uploadForm').submit();  
    var interval = setInterval(function() {   
        $.ajax({    
             dataType : "json",  
             url : "${CONTEXTPATH }/auth/admin/common/getProgress",  
             data:"file=a",
             contentType : "application/json; charset=utf-8",  
             type : "GET",  
             success : function(data, stats) {    
                if(data) {  
                    $('#progressbar').show();  
                    console.log(data);  
                    if (data == '100') {  
                       clearInterval(interval);  
                    } else {  
                        $('#progressbardata').width(data+'%');  
                    }  
                }  
             }   
        });  
    }, 100);  
}  
</script>
</body>
</html>