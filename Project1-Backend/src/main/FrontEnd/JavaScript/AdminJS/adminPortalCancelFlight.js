const form = document.getElementById("cancel_flight");
form.addEventListener("submit",function(event) {
    event.preventDefault();//prevents the default "submit" event
    SubmitForm();
});

async function SubmitForm() {
    const flight_id = form.querySelector("#flightID");
    let cancelledFlight = {//creates an object in JSON format
        "flight_id": flightID.value,
    }
    let response = await fetch("http://localhost:8080/Project1-Backend/flights", {
        method: "POST",
        headers: {"Content-Type": "application/json",
            "Servlet-Action": "AdminCancelFlight"},
        body: JSON.stringify(cancelledFlight)//makes the json into a string to send
    });
}