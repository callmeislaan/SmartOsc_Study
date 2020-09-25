import {Person} from "../domain/Person";
import {TaskDto} from "./TaskDto";
import {Task} from "../domain/Task";

export class PersonDTO {
    id : number;
    firstName : string;
    lastName : string;
    salary : number;
    dob : string;
    status : string;
    tasks : TaskDto[];

    statusStr : string;
    salaryFormatted : string;
    dobFormatted : string;


    constructor(firstName: string, lastName: string, salary: number, dob: string, status: string, tasks: TaskDto[], statusStr: string, salaryFormatted: string, dobFormatted: string) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.dob = dob;
        this.status = status;
        this.tasks = tasks;
        this.statusStr = statusStr;
        this.salaryFormatted = salaryFormatted;
        this.dobFormatted = dobFormatted;
    }
}