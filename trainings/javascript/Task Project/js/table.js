function openCategory(evt, fieldName) {
    let i, tabcontent, buttonLinks;

    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }

   buttonLinks = document.getElementsByClassName("buttonLink");
    for (i = 0; i < buttonLinks.length; i++) {
        buttonLinks[i].className = buttonLinks[i].className.replace(" active", "");
    }

    document.getElementById(fieldName).style.display = "block";
    evt.currentTarget.className += " active";
}

