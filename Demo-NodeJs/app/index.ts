import $ = require("jquery");
import {PersonService} from "./service/PersonService";
import {Person} from "./domain/Person";

$(document).ready(function () {
    let personService: PersonService = new PersonService();

    $("#save").on("click", function () {
        let firstName = $("#firstName").val();
        let lastName = $("#lastName").val();
        let salary = $("#salary").val();
        let dob = $("#dob").val();
        let status = $("#status").val();

        let person : // @ts-ignore
            Person = new Person(firstName, lastName, salary, dob, status);

        save(person, personService);
    });
})

function save(person : Person, personService : PersonService) {
    personService.save(person);
}