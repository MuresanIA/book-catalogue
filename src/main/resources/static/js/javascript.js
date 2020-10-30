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