import {Task} from "./Task";

export class Person {
    id : number;
    firstName : string;
    lastName : string;
    salary : number;
    dob : string;
    status : string;
    tasks : Task[];

    constructor(firstName: string, lastName: string, salary: number, dob: string, status: string, tasks: Task[]) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.dob = dob;
        this.status = status;
        this.tasks = tasks;
    }
}