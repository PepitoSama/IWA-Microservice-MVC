var stompClient = null
var connected = false
var latitude = null
var longitude = null
var x = document.getElementById("error")

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Socket connection
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
function setConnected(connected) {
    $("#connect").prop("disabled", connected)
    $("#disconnect").prop("disabled", !connected)
    if (connected) {
        $("#conversation").show()
    }
    else {
        $("#conversation").hide()
    }
    $("#greetings").html("")
}

function connect() {
    var socket = new SockJS('/gs-guide-websocket')
    this.connected = true
    stompClient = Stomp.over(socket)
    stompClient.connect({}, function (frame) {
        setConnected(true)
        console.log('Connected: ' + frame)
    })
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect()
        this.connected = false
    }
    setConnected(false)
    console.log("Disconnected")
}

function sendPosition() {
    stompClient.send("/app/position", {}, JSON.stringify({
        userId: 1,
        longitude: this.longitude,
        latitude: this.latitude
    }))
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Location functions
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


function getLocation() {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(saveAndSendPosition, showError)
    } else {
        this.writeError("La geolocalisation n'est pas supportée par votre navigateur.")
        this.connect(false)
    }
}

function showError(error) {
    this.disconnect()
    switch(error.code) {
        case error.PERMISSION_DENIED:
            this.writeError("Vous avez refusé le geolocalisation sur votre navigateur.")
            break
        case error.POSITION_UNAVAILABLE:
            this.writeError("Les informations de geolocalisation sont indisponibles.")
            break
        case error.TIMEOUT:
            this.writeError("La requete de geolocalisation à échoué.")
            break
        case error.UNKNOWN_ERROR:
            this.writeError("Erreur inconnue.")
            break
    }
}

function writeError(error) {
    x.innerHTML = error
}

function saveAndSendPosition(position) {
    this.writeError("Latitude: " + position.coords.latitude + "<br>Longitude: " + position.coords.longitude)
    this.latitude = position.coords.latitude
    this.longitude = position.coords.longitude
    sendPosition()
}


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Main
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault()
    })
    $( "#connect" ).click(function() { connect() })
    $( "#disconnect" ).click(function() { disconnect() })

    setInterval(function(){
        if(this.connected) {
            getLocation()
        } else {
            console.log("Not connected")
        }
    }, 1000)
})