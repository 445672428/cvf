define(function (require, exports, module) {

    var devWebSocket = {};
    var indexConfigSocket = function (opt) {
        if ('WebSocket' in window) {
            devWebSocket = new WebSocket("ws://" + window.location.host + basePath + "/app/indexConfig/indexConfigWebSocket.do");
        } else if ('MozWebSocket' in window) {
            devWebSocket = new MozWebSocket(
                "ws://" + window.location.host + basePath + "/ws/point/webSocketServer.do");
        } else {
            devWebSocket = new SockJS(
                "http://" + window.location.host + basePath + "/ws/point/webSocketServer.do");
        }
        devWebSocket.onopen = function (evnt) {
        };
        devWebSocket.onmessage = function (evnt) {
            //console.log("onMessage:"+"</br>(<font color='red'>" + evnt.data + "</font>)")
            window.PubSub.publish('indexConfigSocket-onMessage', evnt);
        };
        devWebSocket.onerror = function (e) {
            console.log('indexConfig webSocket error...');
            for (var p in e) {
                //alert(p + "=" + e[p]);
            }
        };
        devWebSocket.onclose = function (evnt) {
            console.log('indexConfig webSocket error...');
        };
    };

    indexConfigSocket.prototype.send = function (indexConfigIdsStr) {
        var indexConfig = {};
        indexConfig.data = indexConfigIdsStr;
        indexConfig.optType = '';
        var t = JSON.stringify(indexConfig);
        console.log("</br>请求报文：<font color='blue'>" + t + "</font>")
        devWebSocket.send(t);
    };

    indexConfigSocket.prototype.close = function (indexConfigIdsStr) {
        var indexConfig = {};
        indexConfig.data = indexConfigIdsStr == null ? [] : indexConfigIdsStr;
        indexConfig.optType = 'pausePush';
        var t = JSON.stringify(indexConfig);
        console.log("关闭报文：" + t);
        devWebSocket.send(t);
    };


    module.exports = indexConfigSocket;

})