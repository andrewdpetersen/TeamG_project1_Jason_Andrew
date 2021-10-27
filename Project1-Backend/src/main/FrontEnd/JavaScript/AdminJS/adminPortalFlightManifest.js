const adminManifestForm = document.getElementById("admin_flight_manifest");//
adminManifestForm.addEventListener("submit",function(event) {
    event.preventDefault();//prevents the default "submit" event
    SubmitAdminFlightManifestForm();
});

async function SubmitAdminFlightManifestForm() {
    const manifestFlight_id = adminManifestForm.querySelector("#manifest_flightID");
    // // http://localhost:8080/Project1-Backend/flights
    let response = await fetch("P1kiosk-env.eba-djrhmwps.us-east-2.elasticbeanstalk.com/flights", {
        method: "GET",
        headers: {"Content-Type": "application/json",
            "Servlet-action": "AdminFlightManifest",
            "flightID": manifestFlight_id.value},
    });
    var queryString = "?flightID="+manifestFlight_id.value;
    window.location.href = "AdminViewManifest.html"+queryString;
}