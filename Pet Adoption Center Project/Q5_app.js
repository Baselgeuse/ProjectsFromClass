console.log("connected to html");

// Date function

function timeRefresh() {
  const time = document.querySelector(".time");
  const dateString = new Date().toLocaleString();
  const formattedString = dateString.replace(", ", " - ");
  time.textContent = formattedString;
}

setInterval(timeRefresh, 1000);

// Checkbox verification question for find cat/dog

function validityCheck() {
  var isValid = true;
  if (document.querySelector('input[name="breed"]:checked') == null) {
    isValid = false;
    console.log("breed is null");
  } else if (document.querySelector('input[name="range"]:checked') == null) {
    isValid = false;
    console.log("age is null");
  } else if (document.querySelector('input[name="gender"]:checked') == null) {
    isValid = false;
    console.log("gender is null");
  } else if (document.querySelector('input[name="amicCat"]:checked') == null) {
    isValid = false;
    console.log("dogFriend is null");
  } else if (document.querySelector('input[name="amicCat"]:checked') == null) {
    isValid = false;
    console.log("catFriend is null");
  } else if (
    document.querySelector('input[name="amicChild"]:checked') == null
  ) {
    isValid = false;
    console.log("childFriend is null");
  }
  if (isValid == false) {
    alert("Please check all fields");
  }
}

// Checkbox verification question for giveaway

function validityCheck2() {
  var isValid = true;
  if (document.querySelector('input[name="species"]:checked') == null) {
    isValid = false;
    console.log("species is null");
  } else if (document.querySelector('input[name="gender"]:checked') == null) {
    isValid = false;
    console.log("gender is null");
  } else if (document.querySelector('input[name="amicCat"]:checked') == null) {
    isValid = false;
    console.log("dogFriend is null");
  } else if (document.querySelector('input[name="amicCat"]:checked') == null) {
    isValid = false;
    console.log("catFriend is null");
  } else if (
    document.querySelector('input[name="amicChild"]:checked') == null
  ) {
    isValid = false;
    console.log("childFriend is null");
  } else if (document.querySelector("#Breed").value == "") {
    isValid = false;
    console.log("Breed is null");
  } else if (document.querySelector("#Age").value == "") {
    isValid = false;
    console.log("age is null");
  } else if (document.querySelector("#Comment").value == "") {
    isValid = false;
    console.log("comment is null");
  } else if (document.querySelector("#ownerName").value == "") {
    isValid = false;
    console.log("name is null");
  } else if (document.querySelector("#ownerEmail").value == "") {
    isValid = false;
    console.log("age is null");
  }
  if (isValid == false) {
    alert("Please check all fields");
  }
}
