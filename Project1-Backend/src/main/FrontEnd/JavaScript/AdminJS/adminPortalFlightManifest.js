const form = document.getElementById("admin_flight_manifest");//
form.addEventListener("submit",function(event) {
    event.preventDefault();//prevents the default "submit" event
    const fid = form.querySelector("#flightID");
    SubmitForm();
});

async function SubmitForm() {
    let response = await fetch("http://localhost:8080/Project1-Backend/flights", {
        method: "GET",
        headers: {"Content-Type": "application/json",
            "Servlet-Action": "AdminFlightManifest",
            "flightID": fid.value},
    });
}

// TODO: add response logic if necessary
//The only times we need a response: user-Flights, admin-Manifest, admin-Flights

//let json = response.json();
//And the response logic goes here