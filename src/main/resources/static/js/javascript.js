function validateFormCreateAuthor() {
    const firstName = document.forms["createAuthor"]["firstName"].value();
    const lastName = document.forms["createAuthor"]["lastName"].value();

    if (firstName.value === "") {
        window.alert("Please enter author's first name!");
        firstName.focus();
        return false;
    }

    if (lastName.value === "") {
        window.alert("Please enter author's last name!");
        lastName.focus();
        return false;
    }
    return true;
}

const text = document.querySelector("text");

text.addEventListener("input", event => {
    const target = event.currentTarget;
    const maxLength = target.getAttribute("maxlength");
    const currentLength = target.value.length;

    if (currentLength >= maxLength) {
        return console.log("You have reached the maximum number of characters.");
    }

    console.log(`${maxLength - currentLength} chars left`);
});