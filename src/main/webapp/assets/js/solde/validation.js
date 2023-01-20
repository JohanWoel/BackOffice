function setDisabled(button){
    button.disabled=true;
}

function getTR(button){
    return button.parentNode.parentNode;
}

function setGreen(button) {
    setDisabled(button);
    getTR(button).setAttribute("class","table-success");
    setDisabled(document.getElementById("refuse_"+getIdNumber(button.id)));
}

function getIdNumber(id){
    let split=id.split("_");
    return split[1];
}

function setRed(button) {
    setDisabled(button);
    getTR(button).setAttribute("class","table-danger");
    setDisabled(document.getElementById("validate_"+getIdNumber(button.id)));
}

async function validate(idSolde,button) {
    await fetch("http://localhost:1234/soldes/"+idSolde+"/validate",{
        method:"PUT",
    })
        .then(data=> {
            console.log(data)
            setGreen(button);
        })
        .catch(err=>console.log(err));
}

async function refuse(idSolde,button) {
    await fetch("http://localhost:1234/soldes/"+idSolde+"/refuse",{
        method:"PUT",
    })
        .then(data=> {
            console.log(data)
            setRed(button);
        })
        .catch(err=>console.log(err));
}