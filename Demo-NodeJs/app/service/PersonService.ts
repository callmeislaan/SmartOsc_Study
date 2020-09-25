import {Person} from "../domain/Person";
import {ENDPOINT, HTTP_METHOD} from "../util/Contants";
import {Model} from "../repository/Model";
import {PersonDTO} from "../dto/PersonDTO";
import {Task} from "../domain/Task";

export class PersonService {

    private url: string;
    private method = HTTP_METHOD.get;
    private async = true;
    private data = null;
    private personUpdated;

    saveDefine(personDTO : PersonDTO) {
        this.method = HTTP_METHOD.post;
        this.async = false;
        this.data = personDTO;
        Model.callServer(this.url, this.method, this.async, this.data)
            .fail(t => alert("lưu thất bại"))
            .done(t => {
                this.personUpdated = t as PersonDTO;
                alert("Lưu thành công")
            });
    }

    save(personDTO: PersonDTO) {
        this.url = ENDPOINT.save;
        this.saveDefine(personDTO);
    }

    addTask(personDTO: PersonDTO) {
        this.url = ENDPOINT.addTask;
        this.saveDefine(personDTO);
        return this.personUpdated;
    }

    personDTOs: PersonDTO[] = null;

    findByNameAndStatus(name: string, status: string): PersonDTO[] {
        this.url = ENDPOINT.findByNameAndStatus + `?name=${name}${status == "ALL" ? "" : "&status=" + status}`
        this.async = false;
        Model.callServer(this.url, this.method, this.async).done((data: PersonDTO[]) => {
            this.personDTOs = data as PersonDTO[];
        });
        return this.personDTOs;
    }

    getAllTask(personDTO : PersonDTO) {
        this.url = ENDPOINT.getTask;
        this.async = false;
        Model.callServer(this.url, this.method, this.async).done((data: PersonDTO[]) => {
            this.personDTOs = data as PersonDTO[];
        });

        return this.personDTOs;
    }

}