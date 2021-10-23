const form = document.getElementById("admin_flight_manifest");//
form.addEventListener("submit",function(event) {
    event.preventDefault();//prevents the default "submit" event
    SubmitForm();
});

async function SubmitForm() {
    const fid = form.querySelector("#flightID");
    let response = await fetch("http://localhost:8080/Project1-Backend/flights", {
        method: "GET",
        headers: {"Content-Type": "application/json",
            "Servlet-Action": "AdminFlightManifest",
            "flightID": fid.value},
    });
    var queryString = "?flightID="+fid.value;
    window.location.href = "AdminViewManifest.html"+queryString;
}

// TODO: add response logic if necessary
//The only times we need a response: user-Flights, admin-Manifest, admin-Flights

//let json = response.json();
//And the response logic goes here