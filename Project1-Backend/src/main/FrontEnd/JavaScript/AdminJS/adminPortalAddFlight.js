const adminAddForm = document.getElementById("add_flight");
adminAddForm.addEventListener("submit",function(event) {
    event.preventDefault();//prevents the default "submit" event
    SubmitAdminAddFlightForm();
    adminAddForm.reset();
});

async function SubmitAdminAddFlightForm() {
    const departure_city = adminAddForm.querySelector("#departureCity");
    const arrival_city = adminAddForm.querySelector("#arrivalCity");
    const flight_date = adminAddForm.querySelector("#flightDate");
    let newFlight = {//creates an object in JSON format
        "departureCity": departure_city.value,
        "arrivalCity": arrival_city.value,
        "flightDate": flight_date.value
    }
    let response = await fetch("http://localhost:8080/Project1-Backend/flights", {
        method: "POST",
        headers: {"Content-Type": "application/json",
        "Servlet-action": "AdminScheduleFlight"},
        body: JSON.stringify(newFlight)//makes the json into a string to send
    });

    return response.text().then(function(){
        alert(`Flight successfully scheduled!`);
    })
}