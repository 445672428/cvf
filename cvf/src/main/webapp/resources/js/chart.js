function itemWinodwTabChange(){
	var id = "chatcontentWindow";
	var boxId = "chatBox";
	var chatWindow = document.getElementById(id);
	var chatBox = document.getElementById(boxId);
    var value = obj.getElementsByTagName("h4")[0].innerHTML;
    
    document.getElementById("username").innerHTML=document.getElementById('to').value = value;
    chatBox.appendChild(chatWindow.getElementsByTagName("div")[0]);
    chatWindow.appendChild(document.getElementById(value+"box"));
    
    document.getElementsByClassName("inputContent")[0].id = value+"input";
    clearBall();
}

function clearBall() {
    var id= document.getElementById(document.getElementById("username").innerHTML);
    if (id.children.length >=4){
        id.removeChild(id.childNodes[3]);
    }
}