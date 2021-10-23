const form = document.getElementById("login");
form.addEventListener("submit",function(event) {
    event.preventDefault();//prevents the default "submit" event

    SubmitForm();
});

async function SubmitForm() {
    const unm = form.querySelector("#username");
    const pwd = form.querySelector("#password");
    let object = {//creates an object in JSON format
        "username": unm.value,//key is the variable we are assigning the value to
        "password": pwd.value,//the value comes from form input
    }

    let response = await fetch("http://localhost:8080/Project1-Backend/people", {
        method: "POST",
        headers: {"Content-Type": "application/json",
        "Servlet-action" : "Login"
        },
        body: JSON.stringify(object)
        //one to add an object, one to update, one to delete, one to get one object, one to get a list
    });
}

// TODO: add response logic if necessary - send to appropriate PORTAL
//The only times we need a response: user-Flights, admin-Manifest, admin-Flights

//let json = response.json();
//And the response logic goes here