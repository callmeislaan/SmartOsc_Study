import $ = require("jquery");
import {PersonService} from "./service/PersonService";
import {PersonDTO} from "./dto/PersonDTO";
import {TaskDto} from "./dto/TaskDto";


$(document).ready(function () {

    let personService: PersonService = new PersonService();
    let persons: PersonDTO[];

    // search
    $("#search").on("click", function () {
        let name = $("#name").val();
        let status = $("#status").val();
        // @ts-ignore
        persons = personService.findByNameAndStatus(name, status);
        let content = `<tr>
                            <th>STT</th>
                            <th>Tên</th>
                            <th>Lương</th>
                            <th>Ngày sinh</th>
                            <th>Trạng thái</th>
                            <th>Chỉnh sửa</th>
                            <th>Nhiệm vụ</th>
                        </tr>`;
        let stt: number = 1;
        if (persons != null) {
            persons.forEach(personDTO => {
                // let dob = person.dob.split("-");
                content += `<tr>
                                <td class="stt">${stt++}</td>
                                <td class="editable">${personDTO.firstName} ${personDTO.lastName}</td>
                                <td class="editable">${personDTO.salaryFormatted}</td>
                                <td class="editable">${personDTO.dobFormatted}</td>
                                <td class="editable">${personDTO.statusStr}</td>
                                <td>
                                    <button class="btn-edit"">Chỉnh sửa</button>
                                    <button class="btn-save" hidden>Lưu</button>
                                    <button class="btn-cancel" hidden>Hủy</button>
                                </td>
                                <td>
                                    <div class="btn-parent-task">
                                        <button class="btn-task">Thêm nhiệm vụ</button>
                                        <button class="btn-watch-task" id="myBtn">Xem nhiệm vụ</button>
                                    </div>
                                    <div class="add-task" hidden align="center">
                                        <input type="text"><br><br>
                                        <button class="btn-add-task">Thêm</button>
                                        <button class="btn-cancel-task">Hủy</button>
                                    </div>
                                </td>
                            </tr>`;
            })
        }

        $("#table-persons").html(content);
    })

    // edit row

    let parentEdit;
    let editElement;
    let btnEdit;
    let btnSave;
    let btnCancel;

    $(document).on('click', '.btn-edit', function () {
        parentEdit = $(this).parents('tr');
        findElement();
        editing();
    });

    $(document).on('click', '.btn-save', function () {
        parentEdit = $(this).parents('tr');
        findElement();
        edited();
    })

    $(document).on('click', '.btn-cancel', function () {
        parentEdit = $(this).parents('tr');
        findElement();
        edited();
        editElement.each(function (index, val) {
            $(this).attr('defaultValue', $(this).html());
        })
    })

    function findElement() {
        editElement = parentEdit.find('.editable');
        btnEdit = parentEdit.find(".btn-edit");
        btnSave = parentEdit.find('.btn-save');
        btnCancel = parentEdit.find('.btn-cancel');
    }

    function editing() {
        btnEdit.hide();
        btnSave.show();
        btnCancel.show();
        editElement.prop('contentEditable', 'true');
        editElement.css('background', '#F0F8FF');
        editElement.css('border', 'solid 2px blue');
    }

    function edited() {
        btnEdit.show();
        btnSave.hide();
        btnCancel.hide();
        editElement.prop('contentEditable', 'false');
        editElement.css('background', '#fff');
        editElement.css('border', 'solid 1px');
    }

    // add task
    let parentTask;
    let btnAddTask;
    let btnParentTask;
    let btnCancelTask;
    let addTask;
    let personDTO: PersonDTO;

    function findTask() {
        btnParentTask = parentTask.find('.btn-parent-task');
        btnAddTask = parentTask.find('.btn-add-task');
        btnCancelTask = parentTask.find('.btn-cancel-task');
        addTask = parentTask.find('.add-task');
    }

    function editingTask() {
        addTask.show();
        btnParentTask.hide();
    }

    function editedTask() {
        addTask.hide();
        btnParentTask.show();
    }

    $(document).on('click', '.btn-task', function () {
        parentTask = $(this).parents('td');
        findTask();
        editingTask();
    })

    $(document).on('click', '.btn-add-task', function () {
        parentTask = $(this).parents('td');
        findTask();

        // @ts-ignore
        let stt: number = $(this).parents('tr').find('.stt').html();
        let taskName = parentTask.find("input").val();
        personDTO = persons[stt-1];

        // @ts-ignore
        personDTO.tasks = [new TaskDto(taskName, personDTO.id)];

        persons[stt-1] = personService.addTask(personDTO);
    })

    $(document).on('click', '.btn-cancel-task', function () {
        parentTask = $(this).parents('td');
        findTask();
        editedTask();
    })

    $(document).on('click', '.btn-watch-task', function () {
        parentTask = $(this).parents('td');
        findTask();
        editedTask();

        // @ts-ignore
        let stt: number = $(this).parents('tr').find('.stt').html();
        let taskName = parentTask.find("input").val();
        personDTO = persons[stt - 1] as PersonDTO;

        // show modal
        let modal = $("#myModal");

        // Get the button that opens the modal
        let btn = $("#myBtn");

        // Get the <span> element that closes the modal
        let span = $(".close")[0];

        let listTask = $(".list-task");

        let tasksElement = "";

        // console.log(personDTO.tasks.length);

        for (let i = 0; i < personDTO.tasks.length; i++) {
            tasksElement += `<div>${personDTO.tasks[i].name}</div>`
        }

        listTask.html(tasksElement);

        // When the user clicks the button, open the modal
        modal.css("display", "block");


        // When the user clicks on <span> (x), close the modal
        span.onclick = function () {
            modal.css("display", "none");
        }
    })
})
