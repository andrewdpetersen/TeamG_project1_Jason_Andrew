const form = document.getElementById("takeoff_lock");
form.addEventListener("submit",function(event) {
    event.preventDefault();//prevents the default "submit" event
    SubmitTakeoffForm();
    form.reset();
});

async function SubmitTakeoffForm() {
    const fid = form.querySelector("#flightID");
    const spin = form.querySelector("#specialPin");
    let object = {//creates an object in JSON format
        "flightID": fid.value,//key is the variable we are assigning the value to
        "specialPin": spin.value,//the value comes from form input
    }
    //local "http://localhost:8080/Project1-Backend/flights"
    //remote "http://teamgairportkiosk-env.eba-ymppfvdg.us-east-2.elasticbeanstalk.com/flights"
    let response = await fetch("http://localhost:8080/Project1-Backend/flights", {
        method: "POST",
        headers: {"Content-Type": "application/json",
            "Servlet-action": "PilotTakeoffLock"
        },
        //one to add an object, one to update, one to delete, one to get one object, one to get a list
        body: JSON.stringify(object)//makes the json into a string to send
    });

    return response.text().then(function(){
        alert(`CABIN LOCKED`);
        alert(`PRE-FLIGHT CHECKS SUCCESSFUL`);
        alert(`CLEARED FOR TAKEOFF`);
    })
}