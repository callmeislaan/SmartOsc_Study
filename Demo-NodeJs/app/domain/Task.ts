import {Person} from "./Person";

export class Task {
    id : number;
    name : string;
    person : Person;

    constructor(name: string, person: Person) {
        this.name = name;
        this.person = person;
    }
}