  <div role="tabpanel" class="tab-pane active" id="home">
		<form id="form1" action="${CONTEXTPATH }/auth/add4" method="POST">
	      <div class="jumbotron">
	      	 <h2>用户信息</h2>
	      	 <div class="row">
	      	 	<div class="col-sm-1 pull-right">
	      	 		<button class="btn btn-primary glyphicon glyphicon-floppy-disk" type="submit">保存</button>
	      	 	</div>
	      	 </div>
			<div class="form-group col-sm-6">
			    <label for="1-username">姓名：</label>
			    <input type="text" class="form-control" name="username" id="1-username" placeholder="填写真实姓名">
			</div>
	        <div class="form-group col-sm-6">
			    <label for="1-userid">用户名：</label>
			    <input type="text" class="form-control" name="userid" id="1-userid" placeholder="用户名">
			</div>
			<div class="form-group col-sm-6">
			    <label for="1-pwd">密码：</label>
			    <input type="password" class="form-control" name="pwd" id="1-pwd" placeholder="**************">
			</div>
			<div class="form-group col-sm-6">
			    <label for="1-sex">性别：</label>
			    <input type="text" class="form-control" name="sex" id="1-sex" placeholder="男/女">
			</div>
			<div class="form-group col-sm-6">
			    <label for="1-addr">出生地：</label>
			    <input type="text" class="form-control" name="addr" id="1-addr" placeholder="出生地">
			</div>
			<div class="form-group col-sm-6">
			    <label for="1-birth">出生地：</label>
			    <input type="text" class="form-control" name="birth" id="1-birth" placeholder="出生地">
			</div>
			<div class="form-group col-sm-6">
			    <label for="1-movephone">移动电话：</label>
			    <input type="text" class="form-control" name="movephone" id="1-movephone" placeholder="出生年月">
			</div>
			<div class="form-group col-sm-6">
			    <label for="1-email">邮箱：</label>
			    <input type="email" class="form-control" name="email" id="1-email" placeholder="邮箱">
			</div>
			<div class="form-group col-sm-6">
			    <label for="1-phone">电话：</label>
			    <input type="text" class="form-control" name="phone" id="1-phone" placeholder="电话">
			</div>
			<div class="form-group col-sm-6">
			    <label for="1-fax">传真：</label>
			    <input type="text" class="form-control" name="fax" id="1-fax" placeholder="电话">
			</div>
			<div class="form-group col-sm-6">
			    <label for="1-contact">contact：</label>
			    <input type="text" class="form-control" name="contact" id="1-contact" placeholder="电话">
			</div>
			<div class="form-group col-sm-6">
			    <label for="1-userstate">userstate：</label>
			    <input type="text" class="form-control" name="userstate" id="1-userstate" placeholder="电话">
			</div>
			<div class="form-group col-sm-6">
			    <label for="1-remark">remark：</label>
			    <input type="text" class="form-control" name="remark" id="1-remark" placeholder="电话">
			</div>
			<div class="form-group col-sm-6">
			    <label for="1-sysid">sysid：</label>
			    <input type="text" class="form-control" name="sysid" id="1-sysid" placeholder="电话">
			</div>
	      </div>
	  </form>
  </div>
<script type="text/javascript">
/*$(function(){
	var parms = $("#form1").serializeObject();
    $.ajax({type: "POST",url: '${CONTEXTPATH }/auth/add3',headers: {'Content-type': 'application/json;charset=UTF-8'},data:JSON.stringify(parms),dataType:'json',
         contentType:'application/json',success: function(data){
			console.log(data);
        },
        error : function(data){
        }
    });
})*/
</script>