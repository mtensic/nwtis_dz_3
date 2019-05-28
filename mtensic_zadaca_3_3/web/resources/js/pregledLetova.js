var wsocket;

var aplikacija = "/" + document.location.pathname.split("/")[1];
var wsUri = "ws://" + document.location.host + aplikacija + "/infoAerodrom";
wsocket = new WebSocket(wsUri);
wsocket.onmessage = onMessage;

function onMessage(evt) {
    var tip = event.data;
    if (tip == "mqtt") {
        updateJms();
    }
}