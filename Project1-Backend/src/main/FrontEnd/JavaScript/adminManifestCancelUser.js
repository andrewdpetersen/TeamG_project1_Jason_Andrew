const form = document.getElementById("delete_customer");
form.addEventListener("submit",function(event) {
    event.preventDefault();//prevents the default "submit" event
    const customerID = form.querySelector("#customer_id");
    SubmitForm();
});

async function SubmitForm() {
    let object = {//creates an object in JSON format
        "customerID": customerID.value,//key is the variable we are assigning the value to
    }
    let response = await fetch("http://localhost:8080/Project1-Backend/people", {
        method: "POST",
        headers: {"Content-Type": "application/json",
        "Servlet-Action" : "DeleteCustomerFlight"
        },
        //one to add an object, one to update, one to delete, one to get one object, one to get a list
        body: JSON.stringify(object)//makes the json into a string to send
    });
}

// TODO: add response logic if necessary
//The only times we need a response: user-Flights, admin-Manifest, admin-Flights

//let json = response.json();
//And the response logic goes here