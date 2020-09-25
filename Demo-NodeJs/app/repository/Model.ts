import {HTTP_METHOD} from "../util/Contants";
import $ = require("jquery");
import {PersonDTO} from "../dto/PersonDTO";
import {Person} from "../domain/Person";
import jqXHR = JQuery.jqXHR;

export class Model {

    static persons : PersonDTO[] = null;

    public static callServer(url : string, method : string = "GET", async : boolean = true, data : Object = {}) : jqXHR{
        console.log(JSON.stringify(data));
        return $.ajax({
            url : url,
            method : method,
            async : async,
            contentType : "application/json",
            data : method == HTTP_METHOD.get ? "" : JSON.stringify(data)
        });
    }
}