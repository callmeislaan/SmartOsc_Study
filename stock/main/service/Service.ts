import $ = require("jquery");
import {Field} from "../entity/Field";

export class Service {

    public get(sysbol : string, type : number, ) {
        let fields : Field[];
        let URL : string = "https://svr2.fireant.vn/api/Data/Finance/LastestFinancialReports?symbol="+sysbol+"&type="+type+"&year=2020&quarter=0&count=10";
        $.ajax({
            url: URL,
            method: 'GET',
            contentType: 'application/json',
            dataType : 'jsonp',
            async: false
        }).done(data => {
            fields = data as Field[];
            alert("ook");
        }).fail(t => {
            alert("not ok")
        })
        return fields;
    }
}