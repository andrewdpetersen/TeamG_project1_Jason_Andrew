const form = document.getElementById("user_view_flights");//
form.addEventListener("submit",function(event) {
    event.preventDefault();//prevents the default "submit" event
    const sdc = form.querySelector("#select_departureCity");
    const sac = form.querySelector("#select_arrivalCity");
    SubmitForm();
});

async function SubmitForm() {
    let object = {//creates an object in JSON format
        "selectDepartureCity": sdc.value,//key is the variable we are assigning the value to
        "selectArrivalCity": sac.value,//the value comes from form input
    }

    let response = await fetch("http://localhost:8080/Project1-Backend/flights", {
        method: "GET",
        headers: {"Content-Type": "application/json",
        "Servlet-action" : "UserViewFlights"
        },
        //one to add an object, one to update, one to delete, one to get one object, one to get a list
        body: JSON.stringify(object)//makes the json into a string to send
    });
}

// TODO: add response logic if necessary - move to UserFlights.html, print all available flights
//The only times we need a response: user-Flights, admin-Manifest, admin-Flights

//let json = response.json();
//And the response logic goes here