let userportalviewflightsform = document.getElementById("user_view_flights");//
userportalviewflightsform.addEventListener("submit",function(event) {
    event.preventDefault();//prevents the default "submit" event
    SubmitUPVFForm();
});

async function SubmitUPVFForm() {
    const selectDepCity = userportalviewflightsform.querySelector("#select_departureCity");
    const sac = userportalviewflightsform.querySelector("#select_arrivalCity");

    let response = await fetch("http://localhost:8080/Project1-Backend/flights", {
        method: "GET",//NO BODY on GET requests
        headers: {"Content-Type": "application/json",
        "Servlet-action" : "UserViewFlights",
            "selectDepartureCity": selectDepCity.value,
            "selectArrivalCity": sac.value//the value comes from form input
        },
    });
}

// TODO: add response logic if necessary - move to UserFlights.html, print all available flights
//The only times we need a response: user-Flights, admin-Manifest, admin-Flights

//let json = response.json();
//And the response logic goes here