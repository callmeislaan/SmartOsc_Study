export class TaskDto {
    personId : number;
    name : string;

    constructor(name: string, id : number) {
        this.personId = id;
        this.name = name;
    }
}