import {Field} from "./entity/Field";
import {Service} from "./service/Service";

$(document).ready(function () {

    $("input[name='keyword']").keypress(function (event) {
        if (event.keyCode == 13) {
            search();
        }
    })

    $("#btn-search").click(function () {
        search();
    })
})

function search() {
        let keyword : string = String($("input[name='keyword']").val())
        let type = Number($("select[name='ma-bang']").val())
        let field : Field[] = new Service().get(keyword, type);
        console.log(field);
}

function bindData(data : Field) {

}