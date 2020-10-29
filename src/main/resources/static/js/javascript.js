function validateFormCreateAuthor(){
       var firstName =document.forms["createAuthor"]["firstName"];
       var lastName = document.forms["createAuthor"]["lastName"];

        if(firstName.value == ""){
                window.alert("Please enter author's first name!")
                firstName.focus;
                return false;
        }

        if(lastName.value == ""){
            window.alert("Please enter author's last name!")
                last.focus;
                return false;
        }
        return true;
}