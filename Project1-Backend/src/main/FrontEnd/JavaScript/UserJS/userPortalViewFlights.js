let userportalviewflightsform = document.getElementById("user_view_flights");//
userportalviewflightsform.addEventListener("submit",function(event) {
    event.preventDefault();//prevents the default "submit" event
    SubmitUPVFForm();
});

async function SubmitUPVFForm() {
    const selectDepCity = userportalviewflightsform.querySelector("#select_departureCity");
    const sac = userportalviewflightsform.querySelector("#select_arrivalCity");

    let arrive_City = sac.value;
    let depart_City = selectDepCity.value;

    let response = await fetch("http://localhost:8080/Project1-Backend/flights", {
        method: "GET",//NO BODY on GET requests
        headers: {
            "Content-Type": "application/json",
            "Servlet-action": "UserViewFlights",
            "selectDepartureCity": depart_City,
            "selectArrivalCity": arrive_City
        },
    });
    let jsonFlightSchedule = await response.json();

    let flightSchedule = document.getElementById("userFlightScheduleTable");
    for (let element of jsonFlightSchedule) {
        let tr = flightSchedule.insertRow(-1);
        for (let key in element) {
            let cell = tr.insertCell(-1);
            cell.innerHTML = element[key];
        }
    }
    window.location.href = "UserFlights.html"
}

// TODO: add response logic if necessary - move to UserFlights.html, print all available flights
//The only times we need a response: user-Flights, admin-Manifest, admin-Flights

//let json = response.json();
//And the response logic goes here