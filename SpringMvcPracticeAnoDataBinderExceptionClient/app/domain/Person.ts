export class Person {
    id : number;
    age : number;
    dob : string;
    firstName :string;
    lastName : string;
    salary : number;
    status : string;
    
    constructor(age: number, dob: string, firstName: string, lastName: string, salary: number, status: string) {
        this.age = age;
        this.dob = dob;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.status = status;
    }
}